package com.atosorigin.integrale.xmlcompare.test.testclasses;

import java.util.ArrayList;
import java.util.List;

public class TypeE {
	
	private List<TypeA> myList1;
	private List<TypeA> myList2;
	private List<TypeA> myList3;
	
	public TypeE(TypeA a, TypeA b, TypeA c, TypeA d, TypeA e, TypeA f, TypeA g, TypeA h, TypeA i) {
		
		myList1 = new ArrayList<TypeA>();
		myList1.add(a);
		myList1.add(b);
		myList1.add(c);
		
		myList2 = new ArrayList<TypeA>();
		myList2.add(d);
		myList2.add(e);
		myList2.add(f);
		
		myList3 = new ArrayList<TypeA>();
		myList3.add(g);
		myList3.add(h);
		myList3.add(i);
		
	}

}
