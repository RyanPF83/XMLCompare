package com.atosorigin.integrale.xmlcompare.compare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.atosorigin.integrale.xmlcompare.io.xml.XMLFileIn;
import com.atosorigin.integrale.xmlcompare.util.ObjectComparator;

public class CompareXML {
	
	static XMLFileIn xmlfi = new XMLFileIn();
	
	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException {
		
		Object parsed1 = xmlfi.parseXML(args[0]);
		Object parsed2 = xmlfi.parseXML(args[1]);
		

		if (ObjectComparator.compareObjects(parsed1, parsed2, "input object " + parsed1.getClass().getSimpleName())) {
			System.out.println("Match");
		} else {
			System.out.println("Not a Match");
			
			// Get the matches and non-matches data from Comparator
			Map<String, String> matchOrNot = new TreeMap<String, String>(ObjectComparator.getMatchOrNotMap());
			
			// Create a list of "paths" (as strings) for any elements of the compared objects that do not match,
			// at all levels of recursion
			List<String> verboseMismatches = new ArrayList<String>();
			Iterator<Map.Entry<String, String>> it = matchOrNot.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> pair = it.next();
				if (pair.getValue().equals(ObjectComparator.NOT)) {
					verboseMismatches.add(pair.getKey());
				}
			}
			
			// Create a copy of the list to trim down to just the deepest elements of the recursion
			List<String> finalMismatches = new ArrayList<String>(verboseMismatches);
			
			for (String str : verboseMismatches) {
				
				Iterator<String> sit = finalMismatches.iterator();
				while (sit.hasNext()) {
					
					String sub = sit.next();
					
					// Remove any shorter string "paths" as they are not going as deep in the recursion
					if (str.startsWith(sub)) {
						if (sub.length() < str.length()) {
							sit.remove();
						}
					}
				}
			}
			for (String s : finalMismatches) {
				System.err.println("No match found for " + s);
			}
		}
		// Clear the map so Comparator can be used again on more objects
		ObjectComparator.clearMap();
	}
}