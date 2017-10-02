package com.enumdemo;

public class EnumIterate {
	public static void main(String[] args) {
		System.out.println(EnumToIterate.valueOf("JKL")); // valueOf Static
															// produces enum if
															// matches and
															// throws Exception
															// if not
		System.out.println((EnumToIterate.valueOf("JKL") instanceof EnumToIterate));
		for (EnumToIterate enumI : EnumToIterate.values()) { // values() array
																// of Enum in
																// which they
																// are declared
			System.out.print(enumI);
			System.out.print(" - ");
			System.out.print(enumI.ordinal()); // Index in Enum
			System.out.print(" - ");
			System.out.print(enumI.compareTo(EnumToIterate.DEF)); // Equals 0
																	// lest
																	// index -ve
																	// and rest
																	// +ve
			System.out.print(" - ");
			System.out.print(enumI.equals(EnumToIterate.JKL));
			System.out.print(" - ");
			System.out.print(enumI.getDeclaringClass());
			System.out.print(" - ");
			System.out.print(enumI.name()); // String same as toString
			System.out.println();
		}
		for (EnumToIterateWithParam enumH : EnumToIterateWithParam.values()) {
			System.out.println(enumH + "-" + enumH.getStr());
		}
		EnumToIterateWithParam.GHI.setStr("CHANGED");
		for (EnumToIterateWithParam enumH : EnumToIterateWithParam.values()) {
			System.out.println(enumH + "-" + enumH.getStr());
		}
	}
}

enum EnumToIterate { // java.lang.Enum --> Automatically Comparable and
						// Serializable
	ABC, DEF, GHI, JKL;
	EnumToIterate() { // Called 4 times here as initialization of 4 Enum objects
		System.out.println("Heeloo");
	}
	// public static void main(String[] args) { } Enum can have main class
}

enum EnumToIterateWithParam { // java.lang.Enum --> Automatically Comparable and
								// Serializable
	// Enum cannot extends it can only Implement
	ABC("123"), DEF("456"), GHI("789");
	private String str;

	EnumToIterateWithParam(String str) {
		System.out.println("here " + str);
		this.str = str;
		// Enum; Check class final name method is there
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	// public static void main(String[] args) { } Enum can have main class
}

// class ABC implements EnumToIterate{} Cannot extend or implement Enum

interface Food {
	enum Appetizer implements Food {
		SALAD, SOUP;
	}

	enum MainCourse implements Food {
		LASAGNE, VINDALOO, HUMMUS;
	}
}