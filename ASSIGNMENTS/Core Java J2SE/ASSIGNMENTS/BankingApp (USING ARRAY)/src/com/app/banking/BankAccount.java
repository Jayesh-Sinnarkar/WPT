package com.app.banking;

import java.time.LocalDate;

import com.bankingapp.utils.BankingException;

public class BankAccount {
	private int accountNumber;
	private String customerName;
	private String accountType;
	private double accountBalance;
	private LocalDate openingDate;
	
	//	CONSTRUCTOR
	public BankAccount(int accountNumber, String customerName, String accountType, double accountBalance, LocalDate openingDate) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openingDate = openingDate;
	}
	
	//PRINT ACCOUNT SUMMARY IN FOLLOWING FORMAT WHEN INTERNALLY CALLED
	@Override	//	toString
	public String toString() {
		return "----- ACCOUNT SUMMARY -----\nAccount Number:" + accountNumber + "\nCustomer Name :" + customerName + "\nAccount Type :"
				+ accountType + "\nAccount Balance : " + accountBalance + "\nOpening Date : " + openingDate;
	}
	
	@Override	// equals
	public boolean equals(Object anotherBankAccount) {
		if(anotherBankAccount instanceof BankAccount)
			return accountNumber == ((BankAccount)anotherBankAccount).accountNumber;
		return false;
	}
	
	//	WITHDRAW OPERATION
	public void withdraw(double amount) throws BankingException {
		if(amount <= accountBalance) {
			accountBalance = accountBalance - amount;	
			System.out.println("Amount of " + amount +" withdrawn");
		} 	else {		//throw exception - insufficient balance
			throw new BankingException("Insufficient balance");
		}
	}

	//	DEPOSIT OPERATION
	public void deposit(double amount) throws BankingException {
		if(amount > 0) {
			accountBalance = accountBalance + amount;
			System.out.println("Amount of " + amount +" deposited");
		}	else {		//throw exception - invalid amount
			throw new BankingException("Invalid amount");
		}
	}
	
	//	FUND TRANSFER OPERATION
	public void fundTransfer(double amount, BankAccount anotherAccount) throws BankingException {
		if(anotherAccount != null && amount <= accountBalance) {
			accountBalance = accountBalance - amount;
			anotherAccount.accountBalance = anotherAccount.accountBalance + amount;
			System.out.println("Funds successfully transferred from Acc/No " + accountNumber + " to Acc/No " + anotherAccount.accountNumber);
		} else {		//throw exception - insufficient balance
			throw new BankingException("Insufficient balance");
		}
	}
}
