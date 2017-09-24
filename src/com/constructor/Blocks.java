package com.constructor;

public class Blocks {
	public static void main(String[] args) {
		new WhichBlock();
		new WhichBlock();
	}
}

class WhichBlock {
	{
		System.out.println("I'm default");
	}
	static {
		System.out.println("I'm static");
	}

	public WhichBlock() {
		System.out.println("I'm constructed");
	}
}