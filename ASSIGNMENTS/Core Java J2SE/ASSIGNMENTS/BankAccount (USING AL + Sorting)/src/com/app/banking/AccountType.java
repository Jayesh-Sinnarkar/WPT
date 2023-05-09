package com.app.banking;

public enum AccountType {
	SAVINGS(2000), CURRENT(5000), FD(100000), DEMAT(10000);

	double minBal;
	
	AccountType()
	{
		this.minBal=2000;
	}
	
	AccountType(float minB)
	{
		this.minBal=minB;
	}
	
	public double getMinimumBalance(){
		return minBal;
	}
	
}