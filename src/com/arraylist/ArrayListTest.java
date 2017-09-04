package com.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1, 66); //--> Will throw IndexOutofBoundException
		System.out.println(list);
	}
}
