package com.app.customExceptions;



@SuppressWarnings("serial")
public class DuplicateAccountException extends Exception{

	public DuplicateAccountException(String message) {
		super(message);
	}

}
