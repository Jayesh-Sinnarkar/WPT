package com.app.customExceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {


	public InsufficientBalanceException(String str) {
		super( str);
	}

}
