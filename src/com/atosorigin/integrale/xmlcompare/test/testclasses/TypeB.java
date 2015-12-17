package com.atosorigin.integrale.xmlcompare.test.testclasses;

public class TypeB extends TypeA{
	
	private float decimal;

	public TypeB(int a, String b, float c) {
		super(a, b);
		setDecimal(c);
	}

	public float getDecimal() {
		return decimal;
	}

	public void setDecimal(float decimal) {
		this.decimal = decimal;
	}
	
//	@Override
//	public String toString() {
//		
//		return "Number: " + getNumber() + ", Words: " + getWords() + ", Decimal: " + getDecimal(); 
//		
//	}

}
