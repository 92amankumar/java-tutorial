package com.basics;

import java.util.Arrays;

public class ArraysCopyOfSystemArrayCopy {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arrCopy = Arrays.copyOf(arr, arr.length); // Creates new array
		for (int i = 0; i < arrCopy.length; i++) {
			System.out.println(arrCopy[i]);
		}
		System.out.println();
		int[] systemArr = new int[arr.length];
		System.arraycopy(arr, 0, systemArr, 0, arr.length); // Does not creates
															// new
		for (int i = 0; i < systemArr.length; i++) {
			System.out.println(systemArr[i]);
		}
	}
}
