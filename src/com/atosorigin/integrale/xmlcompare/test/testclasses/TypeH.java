package com.atosorigin.integrale.xmlcompare.test.testclasses;

import java.util.ArrayList;
import java.util.List;

public class TypeH {
	
	private List<List<List<TypeA>>> myListofTypeALists;
	
	public TypeH(TypeA a1, TypeA a2, TypeA a3, TypeA a4, TypeA a5, TypeA a6, TypeA a7, TypeA a8) {
		
		myListofTypeALists = new ArrayList<List<List<TypeA>>>();
		List<List<TypeA>> myTypeALists1 = new ArrayList<List<TypeA>>();
		List<List<TypeA>> myTypeALists2 = new ArrayList<List<TypeA>>();
		
		List<TypeA> list1 = new ArrayList<TypeA>();
		List<TypeA> list2 = new ArrayList<TypeA>();
		
		list1.add(a1);
		list1.add(a2);
		myTypeALists1.add(list1);
		
		list2.add(a3);
		list2.add(a4);
		myTypeALists1.add(list2);
		
		List<TypeA> list3 = new ArrayList<TypeA>();
		List<TypeA> list4 = new ArrayList<TypeA>();
		
		list3.add(a5);
		list3.add(a6);
		myTypeALists2.add(list3);
		
		list4.add(a7);
		list4.add(a8);
		myTypeALists2.add(list4);

		myListofTypeALists.add(myTypeALists1);
		myListofTypeALists.add(myTypeALists2);
		
	}

}
