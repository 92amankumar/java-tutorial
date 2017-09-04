package com.trycatch;

public class ReturnFinally {
	public static void main(String[] args) {
		try {
			return;
		} catch (Exception e) {
			return;
		} finally {
			System.out.println("finally");
		}
	}
}
