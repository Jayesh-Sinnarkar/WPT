package com.app.customExceptions;

@SuppressWarnings("serial")
public class ActiveSessionFoundException extends Exception
{
	public ActiveSessionFoundException(String msg)
	{
		super(msg);
	}
}
