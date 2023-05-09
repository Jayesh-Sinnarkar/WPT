package com.assignment2.stack;

import com.assignment2.customer.Customer;

public class FixedStack implements Stack {
	int topOfStack = -1;
	Customer[] cust = new Customer[STACK_SIZE];
	
	@Override
	public void push(Customer custRef) {
		if(topOfStack < STACK_SIZE-1) {
			cust[++topOfStack] = custRef;
		} else {
			System.out.println("Error : Stack Overflow!");
			System.out.println("Details of " + custRef.getCustomerName() + " not stored in stack.");
		}
	}
	
	@Override
	public Customer pop() {
		if(topOfStack >= 0 ) {
			return cust[topOfStack--];	
		} else {
			System.out.println("Error : Stack undeflow!");
		}	
		return null;
	}
}
