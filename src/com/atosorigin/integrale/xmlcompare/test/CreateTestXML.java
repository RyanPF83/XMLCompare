package com.atosorigin.integrale.xmlcompare.test;

//import testclasses.TypeA;
//import testclasses.TypeB;
//import testclasses.TypeC;
//import testclasses.TypeD;
//import testclasses.TypeE;
//import testclasses.TypeF;
//import testclasses.TypeG;
//import testclasses.TypeH;
import com.atosorigin.integrale.xmlcompare.io.xml.XMLFileIn;
import com.atosorigin.integrale.xmlcompare.io.xml.XMLFileOut;
import com.atosorigin.integrale.xmlcompare.io.xml.XMLPrintOut;
import com.atosorigin.integrale.xmlcompare.test.testclasses.TypeI;

public class CreateTestXML {
	
	static XMLPrintOut xmlpo = new XMLPrintOut();
	static XMLFileOut xmlfo = new XMLFileOut();
	static XMLFileIn xmlfi = new XMLFileIn();
	
	public static void main(String[] a) {
		

//		TypeA a1 = new TypeA(1, "A");
//		TypeA a2 = new TypeA(2, "B");
//		TypeA a3 = new TypeA(3, "c");
//		TypeA a4 = new TypeA(4, "D");
//		TypeA a5 = new TypeA(5, "E");
//		TypeA a6 = new TypeA(6, "F");
//		TypeA a7 = new TypeA(7, "G");
//		TypeA a8 = new TypeA(8, "H");
//		TypeA a9 = new TypeA(9, "I");
		
//		TypeB b1 = new TypeB(10, "AA", 1.1f);
//		TypeB b2 = new TypeB(20, "BB", 2.2f);
		
//		String a1 = "AAA";
//		String a2 = "BBB";
//		String a3 = "CCC";
//		String a4 = "DDD";
//		String a5 = "EEE";
//		String a6 = "FFF";
//		String a7 = "GGG";
//		String a8 = "HHH";

//		TypeE e = new TypeE(a1, a2, a3, a4, a5, a6, a7, a8, a9);
		
		TypeI i = new TypeI("a", "b", "c", "d", "e", "f", "g", "h");
		
		xmlpo.createXML(i);
		xmlfo.createXML(i);
		
	}

}
