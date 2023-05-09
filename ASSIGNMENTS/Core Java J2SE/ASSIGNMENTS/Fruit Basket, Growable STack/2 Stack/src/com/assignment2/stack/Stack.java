package com.assignment2.stack;

import com.assignment2.customer.*;

public interface Stack {
	public static final int STACK_SIZE = 5;
	
	public abstract void push(Customer custRef);
	
	Customer pop();
}
