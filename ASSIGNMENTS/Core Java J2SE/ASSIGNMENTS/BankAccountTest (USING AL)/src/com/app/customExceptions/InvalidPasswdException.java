package com.app.customExceptions;


@SuppressWarnings("serial")
public class InvalidPasswdException extends Exception {

	public InvalidPasswdException(String msg)
	{
		super(msg);
	}
}
