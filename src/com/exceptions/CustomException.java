package com.exceptions;

public class CustomException {

}

class MyCustomException extends Exception {
	private static final long serialVersionUID = 1L;
	private float accBal;

	public MyCustomException(float accBal) {
		super();
		this.accBal = accBal;
	}

	public MyCustomException(String message) {
		super(message);
	}
}