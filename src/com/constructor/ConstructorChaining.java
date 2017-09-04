package com.constructor;

//Constructor chaining from super class to sub class
class A {
	A(){
		System.out.println("A");
	}
}
class B extends A {
	B(){
		System.out.println("B");
	}
}
class C extends B {
	C(){
		System.out.println("C");
	}
}
public class ConstructorChaining {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.hashCode());
	}
}
