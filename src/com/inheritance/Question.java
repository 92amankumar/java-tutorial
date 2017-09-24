package com.inheritance;

public class Question {
	public static void main(String[] args) {
		// Child child = new Parent(); Error cannot convert from Parent to Child
	}
}

class Parent {
	void myMethod() {
		System.out.println("ABC");
	}
}

class Child extends Parent {
	void myMethod() {
		System.out.println("ABC");
	}
}