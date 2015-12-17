package com.atosorigin.integrale.xmlcompare.test.testclasses;

public class TypeD extends TypeC {
	
	private TypeA typeA;
	private TypeA typeA2;
	private TypeA typeA3;

	public TypeD(int a, String b, TypeB c, TypeA d, TypeA e, TypeA f) {
		super(a, b, c);
		setTypeA(d);
		setTypeA2(e);
		setTypeA3(f);
	}

	public TypeA getTypeA() {
		return typeA;
	}

	public void setTypeA(TypeA typeA) {
		this.typeA = typeA;
	}

	public TypeA getTypeA2() {
		return typeA2;
	}

	public void setTypeA2(TypeA typeA2) {
		this.typeA2 = typeA2;
	}
	
	public TypeA getTypeA3() {
		return typeA3;
	}

	public void setTypeA3(TypeA typeA3) {
		this.typeA3 = typeA3;
	}

}
