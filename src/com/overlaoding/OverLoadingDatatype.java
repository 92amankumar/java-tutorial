package com.overlaoding;

public class OverLoadingDatatype {
	public static void main(String[] args) {
		OverLoadingDatatype obj = new OverLoadingDatatype();
		// obj.getValue(null); ambiguous
		obj.getValue(1); // chooses primitive over Wrapper
		obj.getValue(1.0); // By default double
		obj.getValue(1.0F);
	}

	void getValue(String i) {
		System.out.println("String " + i);
	}

	void getValue(Integer i) {
		System.out.println("Integer " + i);
	}

	void getValue(int i) {
		System.out.println("int " + i);
	}

	void getValue(byte i) {
		System.out.println("byte " + i);
	}

	void getValue(Double i) {
		System.out.println("Double " + i);
	}

	void getValue(Float i) {
		System.out.println("Float " + i);
	}

	void getValue(float i) {
		System.out.println("float " + i);
	}
}
