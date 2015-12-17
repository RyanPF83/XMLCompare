package com.atosorigin.integrale.xmlcompare.test.testclasses;

import java.util.ArrayList;
import java.util.List;

public class TypeF {
	
	private List<List<String>> myList;
	
	public TypeF(String a, String b, String c, String d) {
		
		List<String> stringList1 = new ArrayList<String>();
		List<String> stringList2 = new ArrayList<String>();
		myList = new ArrayList<List<String>>();
		
		stringList1.add(a);
		stringList1.add(b);
		stringList2.add(c);
		stringList2.add(d);
		
		myList.add(stringList1);
		myList.add(stringList2);
		
	}

}
