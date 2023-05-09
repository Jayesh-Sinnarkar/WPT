package com.assignment2.stack;

import com.assignment2.customer.Customer;

public class GrowableStack implements Stack {
	int topOfStack = -1;
	Customer[] cust = new Customer[STACK_SIZE];
	
	@Override
	public void push(Customer custRef) {
		if(topOfStack < cust.length - 1) {
			cust[++topOfStack] = custRef;
		} else {
			Customer[] tempCustStack = new Customer[cust.length * 2];
			System.out.println("New Stack of twice size created...");
			for(int i = 0; i < cust.length; i++) {
				tempCustStack[i] = cust[i];
			}
			System.out.println("Data copied to new stack...");
			cust = tempCustStack;
			System.out.println("New stack available for push operation...");
			cust[++topOfStack] = custRef;
			System.out.println(custRef.getCustomerName() + " pushed to stack");
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
