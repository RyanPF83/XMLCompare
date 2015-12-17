package com.atosorigin.integrale.xmlcompare.test.testclasses;

import java.util.ArrayList;
import java.util.List;

public class TypeG {
	
	private List<List<TypeA>> myTypeALists;
	
	public TypeG(TypeA a1, TypeA a2, TypeA a3, TypeA a4, TypeA a5, TypeA a6) {
		
		myTypeALists = new ArrayList<List<TypeA>>();
		
		List<TypeA> list1 = new ArrayList<TypeA>();
		List<TypeA> list2 = new ArrayList<TypeA>();
		
		list1.add(a1);
		list1.add(a2);
		list1.add(a3);
		
		list2.add(a4);
		list2.add(a5);
		list2.add(a6);
		
		myTypeALists.add(list1);
		myTypeALists.add(list2);
		
	}

	public List<List<TypeA>> getMyTypeALists() {
		return myTypeALists;
	}

	public void setMyTypeALists(List<List<TypeA>> myTypeALists) {
		this.myTypeALists = myTypeALists;
	}

}
