package com.atosorigin.integrale.xmlcompare.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldGetter {
	
	// Get list of fields found in Class clazz
	public static List<Field> getFields(Class<?> clazz) {
		
		List<Field> retFields = new ArrayList<Field>();
		
		for (Class<?> c = clazz; c != null && c.getSuperclass() != null && !c.getName().startsWith("java."); c = c.getSuperclass()) {
		
			Field[] fields = c.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				retFields.add(f);
				
			}
		}
		
		return retFields;
		
	}
	
	// Get a field with the given name and type from the provided Object
	public static Field getField(Object obj, String fieldName, Class<?> fieldType) {
		
		List<Field> fields = getFields(obj.getClass());
		Field retfield = null;
		
		for (Field f : fields) {
			
			if (f.getName().equals(fieldName) && f.getType().equals(fieldType)) {
				
				retfield = f;
				break;
				
			}
			
		}
		return retfield;
		
	}
	
	// Get a field with a given name and type from a provided list of fields
	public static Field getField(List<Field> fields, String fieldName, Class<?> fieldType) {
		
		Field retfield = null;
		
		for (Field f : fields) {
			
			if (f.getName().equals(fieldName) && f.getType().equals(fieldType)) {
				
				retfield = f;
				break;
				
			}
			
		}
		return retfield;
		
	}

}