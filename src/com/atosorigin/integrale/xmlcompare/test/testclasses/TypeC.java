package com.atosorigin.integrale.xmlcompare.test.testclasses;

public class TypeC {
	
	private int number;
	private String words;
	private TypeB typeB;
	
	public TypeC(int a, String b, TypeB c) {
		setNumber(a);
		setWords(b);
		setTypeB(c);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public TypeB getTypeB() {
		return typeB;
	}

	public void setTypeB(TypeB typeB) {
		this.typeB = typeB;
	}

}
