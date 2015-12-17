package com.atosorigin.integrale.xmlcompare.test.testclasses;

import java.util.ArrayList;
import java.util.List;

public class TypeI {
	
	private List<List<List<String>>> myListofTypeALists;
	
	private TypeB typeB;
	private TypeB typeB2;
	
	public TypeI(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8) {
		
		myListofTypeALists = new ArrayList<List<List<String>>>();
		List<List<String>> myTypeALists1 = new ArrayList<List<String>>();
		List<List<String>> myTypeALists2 = new ArrayList<List<String>>();
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list1.add(a1);
		list1.add(a2);
		myTypeALists1.add(list1);
		
		list2.add(a3);
		list2.add(a4);
		myTypeALists1.add(list2);
		
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		
		list3.add(a5);
		list3.add(a6);
		myTypeALists2.add(list3);
		
		list4.add(a7);
		list4.add(a8);
		myTypeALists2.add(list4);

		myListofTypeALists.add(myTypeALists1);
		myListofTypeALists.add(myTypeALists2);
		
		setTypeB(new TypeB(12, "test", 5.4f));
		setTypeB2(new TypeB(13, "tester", 5.5f));
		
	}

	public TypeB getTypeB() {
		return typeB;
	}

	public void setTypeB(TypeB typeB) {
		this.typeB = typeB;
	}

	public TypeB getTypeB2() {
		return typeB2;
	}

	public void setTypeB2(TypeB typeB2) {
		this.typeB2 = typeB2;
	}

}
