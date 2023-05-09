package com.app.customExceptions;

@SuppressWarnings("serial")
public class NoActiveSessionFound extends Exception{

	public NoActiveSessionFound(String msg){
		super(msg);
	}
}
