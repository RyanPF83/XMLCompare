package com.atosorigin.integrale.xmlcompare.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class ObjectComparator {
	
	public static final String NOT = "NOT";
	private static Map<String, String> matchOrNot = new TreeMap<String, String>();
	private static int mismatchCounter = 0;

	public static Map<String, String> getMatchOrNotMap() {
		return matchOrNot;
	}
	
	public static void clearMap() {
		matchOrNot.clear();
	}
	
	public static boolean compareObjects(Object left, Object right, String path) throws IllegalArgumentException,
																							IllegalAccessException {
			
		// If objects are both null - match, no need to test further
		if (left == null && right == null) {
			return true;
		}
		
		// Use FieldGetter to populate lists of fields of the left and right objects
		List<Field> leftFields = new ArrayList<Field>(FieldGetter.getFields(left.getClass()));
		
		// If objects are of different types - not a match
		if (!(left.getClass().equals(right.getClass()))) {
			return false;
		}
		
		// Iterate through fields of left object, comparing with the equivalent fields in the right object
		for (Field lf : leftFields) {
			
			String leftName = lf.getName();
			Object leftValue = lf.get(left);
			Class<?> leftType = lf.getType();
			
			Field rf = FieldGetter.getField(right, leftName, leftType);
			Object rightValue = rf.get(right);
			
			// Test the fields of the left and right objects. If they match, remove them from the right list. If the right
			// list is empty at the end, the objects match.
			
			// Test if fields are not both "null"
			if ((leftValue == null || leftValue.equals("")) && (!rightValue.equals("") || rightValue != null)) {
				mismatchCounter++;
			}
			
			// Testing "primitives"
			if (leftType.isPrimitive() || leftType.getName().equals("java.util.Date") 
					|| leftType.getName().equals("java.time.LocalDate") || leftType.getName().equals("java.time.LocalDateTime")) {
				if (!leftValue.equals(rightValue)) {
					// As a final (recursively speaking) field, add unmatched data to map
					matchOrNot.put(path + ": " + leftType.getSimpleName() + " " + leftName + ": " + leftValue + " != "
							+ rightValue, NOT);
					mismatchCounter++;
				}
			
			// Testing BigDecimals
			}else if (leftType.getName().equals("java.math.BigDecimal")) {
				BigDecimal leftbd = (BigDecimal) leftValue;
				BigDecimal rightbd = (BigDecimal) rightValue;
				if (leftbd.compareTo(rightbd) != 0) {
					// As a final (recursively speaking) field, add unmatched data to map
					matchOrNot.put(path + ": " + leftType.getSimpleName() + " " + leftName + ": " + leftbd + " != " + rightbd, NOT);
					mismatchCounter++;
				}
				
			// Testing Strings
			} else if (leftType.getName().equals("java.lang.String")) {
				
				if (!leftValue.equals(rightValue)) {
					// As a final (recursively speaking) field, add unmatched data to map
					matchOrNot.put(path + ": " + leftType.getSimpleName() + " " + leftName + ": \"" + leftValue + "\" != \""
							+ rightValue + "\"", NOT);
					mismatchCounter++;
				}
				
			// Testing Lists
			} else if (leftType.getName().equals("java.util.List")) {
				
				@SuppressWarnings("unchecked")
				List<Object> leftList = (List<Object>)leftValue;
				@SuppressWarnings("unchecked")
				List<Object> rightList = (List<Object>)rightValue;
				if (!compareLists(leftList, rightList, path + ": " + leftType.getSimpleName() + " " + leftName)) {
					mismatchCounter++;
				}
				
			// Testing objects
			} else {

				// Recursively call this method on the left and right fields, and update the path to "go deeper"
				if (!compareObjects(leftValue, rightValue, path + ": " + leftType.getSimpleName() + " " + leftName)) {
					mismatchCounter++;
				}
			}
		}
		// mismatchCounter will be 0 if all of the fields match
		if (mismatchCounter > 0) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean compareLists(List<Object> left, List<Object> right, String initPath) throws IllegalArgumentException,
																										IllegalAccessException {
		int counter = 0;
		
		// Iterate through the left list
		for (Object lo : left) {				
			
			// Iterate through the right list
			Iterator<Object> rit = right.iterator();
			while (rit.hasNext()) {
				
				String path = initPath + "["+counter+"]";
				Object ro = rit.next();
				
				// Check if the value at current index is a Date, String or "primitive" etc - primitives are wrapped as they
				// are cast as objects
				if (lo instanceof String || lo instanceof Long || lo instanceof Integer || lo instanceof BigDecimal 
						|| lo instanceof Double || lo instanceof Float || lo instanceof Short || lo instanceof Byte 
						|| lo instanceof Character || lo instanceof Date || lo.getClass().getName().equals("java.time.LocalDate")) {
					
					if (lo.equals(ro)) {
						rit.remove();
						break;
					}
					
				// If the current value is a BigDecimal
				} else if (lo instanceof BigDecimal) {
					
					BigDecimal lbd = (BigDecimal) lo;
					BigDecimal rbd = (BigDecimal) ro;
					
					if (lbd.compareTo(rbd) == 0) {
						rit.remove();
						break;
					}
					
				// If current index contains another list, then compare recursively
				} else if (lo instanceof List) {
					if (compareLists((List<Object>)(lo), (List<Object>)ro, path)) {
						rit.remove();
						break;
					}
					
				// If current index is an object, compare objects
				} else {
					if (compareObjects(lo, ro, path)) {
						rit.remove();
						break;
					}
				}
			}
			counter++;
		}
		
		/**
		 * The matchOrNot map is only written to at the end of the List method (and not in the loops) as we only want to know
		 * whether or not the two supplied lists match. We can not say for certain (in nested lists especially) which elements
		 * within the each list are meant to match each other (as, unlike fields in a Class, the elements are not named), so we can
		 * not return e.g. that List1:String="Hello" does not match List2:String="Hi!". Later in the loops we might find a "Hi!" in
		 * List1, and perhaps the element in List2 that was meant to match with "Hello" from List1 was replaced in List2 with
		 * something else entirely, we just can't say (or at least, the program can not say!). All we can do is say that the Lists
		 * do not match, and say what elements from List1 remain unmatched so that they can be manually checked.
		 */
		
		if (right.isEmpty()) {
			// Add "match" to the map when the left and right lists do not match so that if we have nested lists and end up
			// checking this one again, we know we have already successfully matched it
			// This will overwrite any other match of not data
			matchOrNot.put(initPath, "MATCH");
			return true;
		}
		
		// If we have already decided whether or not this list matches, we will not overwrite the information in the map
		// (this safely leaves "MATCH" in the map if we have already matched the lists
		if (!(matchOrNot.containsKey(initPath))) {
			matchOrNot.put(initPath, NOT);
		}
		return false;
	}
}