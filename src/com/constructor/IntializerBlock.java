package com.constructor;

public class IntializerBlock {
	IntializerBlock(){
		System.out.println("IntializerBlock");
	}
	IntializerBlock(int i){
		System.out.println("IntializerBlock "+i);
	}
	{
		System.out.println("Inside IntializerBlock");
	}
	public static void main(String[] args) {
		IntializerBlock i = new IntializerBlock();
		IntializerBlock j = new IntializerBlock(10);
		System.out.println(i.hashCode()+j.hashCode());
	}
}
