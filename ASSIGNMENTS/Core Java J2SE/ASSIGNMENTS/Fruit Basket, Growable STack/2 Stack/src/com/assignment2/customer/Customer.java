package com.assignment2.customer;

public class Customer {
	int customerId;
	String name;
	String address;
	static int customerIdKey = 100;
	
	public Customer(String name, String address) {
		customerId = ++customerIdKey;
		this.name = name;
		this.address = address;
	}

	//getters
	public String getCustomerName() {
		return name;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	//setters
	public void setCustomerName(String customerName) {
		this.name = customerName;
	}
	
	//toString
	public String toString() {
		return "Customer ID : " + customerId + " Customer Name : " + name + " Address : " + address;
	}
	
}
