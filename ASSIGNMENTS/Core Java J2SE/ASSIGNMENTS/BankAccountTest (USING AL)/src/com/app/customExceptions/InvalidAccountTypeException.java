package com.app.customExceptions;



@SuppressWarnings("serial")

public class InvalidAccountTypeException extends Exception{

	public InvalidAccountTypeException(String message) {
		super(message);
	}

}
