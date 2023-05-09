package com.app.banking;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.app.customExceptions.InsufficientBalanceException;
import com.app.utils.ValidationRules;



public class BankAccount {
	//DECLARING BankAccount DATA MEMBERS
	private int accNumber;
	private String customerName;
	private AccountType accountType;
	private double accountBalance; 
	private double minBalanceAmount;  
	LocalDate accountOpeningDate;
	private String passwd;
	public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();

	
	//DEFAULT CONSTRUCTOR
	public BankAccount() {
		
	}
	//CONSTRUCTOR FOR VALIDATING OR COMPARING ACCOUNT NUMBER
	public BankAccount(int i) {
		this.accNumber = i;	
	}
	
	
	//CONSTRUCTOR FOR CREATING BANK ACCOUNT
	public BankAccount(int accountNo, String customerName, AccountType accountType, double accountBalance, String accountOpeningDate, String passwd) {
		
		super();
		this.accountType = accountType;
		this.accNumber = accountNo;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateTime = LocalDate.parse(accountOpeningDate, formatter);
		this.accountOpeningDate = dateTime;
		this.minBalanceAmount = this.accountType.getMinimumBalance();
		this.passwd = passwd;
	}
	
	//GETTERS FOR VALIDATION PURPOSE 
	public int getAccNumber() {
		return accNumber;
	}

	public String getPasswd() {
		return passwd;
	}

	public double getAccountBalance() {
		
		return accountBalance;
	}

	public double getMinBalanceAmount() {
		return minBalanceAmount;
	}


	//TO PRINT BANK ACCOUNT INFO IN FOLLOWING FORMAT WHEN toSting() CALLED INTERNALLY
	@Override
	public String toString() {
		System.out.println("----------------------------------------");

		return "\nBankAccount: \n             Account Number "+accNumber+"\n             CustomerName= " + customerName + 
				",\n             AccountType= " + accountType + ",\n             AccountBalance= "
				+ accountBalance + ",\n             AccountOpeningDate= "+accountOpeningDate+". \n----------------------------------------\n";
	}
	
	
	
	
	//FOR CHECKING DUPLICATE ACCOUNT NUMBER 
	@Override
	public boolean equals(Object obj) {
		BankAccount accEqu = (BankAccount) obj;
		
		return this.accNumber == accEqu.accNumber;
	}

	
	//WITHDRAW OPERATION
	public boolean withdrawBalance(double withdrawAmount) throws InsufficientBalanceException
	{
		
		if(ValidationRules.validateSufficientBalance(this.accountBalance, withdrawAmount, this.minBalanceAmount))
		{
					this.accountBalance -= withdrawAmount;
					System.out.println("\n\nAmount Rs."+withdrawAmount+" Debited From Account No "+this.accNumber+" Final Account balance is: "+ this.accountBalance);
					return true;
		}
		
		System.out.println("Account balance is less than minimum balance :"+ this.minBalanceAmount);
		return false;
	}
	
	
	//DEPOSIT OPERATION
	public boolean depositAmount(double amount) {
		
		this.accountBalance += amount;
		System.out.println("\n\nAmount "+amount+" added to account No."+this.accNumber+" Final Account Balance: "+this.accountBalance);
		return true;
	}
	
	
	//TRANSFFER OPERATION: INVOKING WITHDRAW & DEPOSIT OPERATIONS INTERNALLY
	public boolean fundsTransffer(double amount,BankAccount acc) throws InsufficientBalanceException
	{
		
		if(this.withdrawBalance(amount) && acc.depositAmount(amount))
		{
			return true;
		}
				
		return false;
	}
	
	//CREATING BANK ACCOUNT: GETTING USER INPUT AFTER DOING VALIDATIONS
	public static void createBankAccount(Scanner in)
	{	
		String customerName;
		AccountType accountType;
		double accountBalance;
		String accountOpeningDate;
		int accNo;
		BankAccount acc = null;
		String passwd;
		

		try {
			
		System.out.print("Enter Customer Name: ");
		customerName = in.nextLine();
		
		System.out.print("Enter Bank Account Number: ");
		accNo = ValidationRules.validateDuplicateAccount(in.nextInt());
		
		System.out.print("Enter Password: ");
		passwd = in.next();		
		
		System.out.print("Enter Account Type (SAVINGS or CURRENT): ");
		accountType = ValidationRules.validateAccountType(in.next().toUpperCase());
		
		System.out.print("Enter Initial Balance Amount Deposit: ");
		accountBalance = ValidationRules.validateMinimumBalance(accountType, in.nextDouble());
		
		in.nextLine();
		
		System.out.print("Enter Account Opening Date [DD-MM-YYYY]: ");
		accountOpeningDate = in.nextLine();	
		acc = new BankAccount(accNo, customerName, accountType, accountBalance, accountOpeningDate, passwd);
	    System.out.println("\n\n\n Bank Account Created with Following Details: "+ acc);
	    
	    BankAccount.bankAccounts.add(acc);
	    

		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	


}
