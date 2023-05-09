package com.app.customExceptions;


@SuppressWarnings("serial")
public class DestinationAccountDoesNotExists extends Exception{

	public DestinationAccountDoesNotExists(String message) {
		super(message);
	}

}
