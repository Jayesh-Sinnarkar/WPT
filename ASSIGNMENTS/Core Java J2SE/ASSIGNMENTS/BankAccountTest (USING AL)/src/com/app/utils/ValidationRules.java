package com.app.utils;


import com.app.customExceptions.*;


import com.app.banking.AccountType;
import com.app.banking.BankAccount;

public class ValidationRules{
	
	
	
	//CHECK IF BANKACCOUNT EXISTS
	public static BankAccount ifAccountExitsts(BankAccount accNo) throws DestinationAccountDoesNotExists
	{
		if(BankAccount.bankAccounts.contains(accNo))				
		return BankAccount.bankAccounts.get(BankAccount.bankAccounts.indexOf(accNo));;
		 
		throw new DestinationAccountDoesNotExists("This Account Number does not exists in our record... Thank You...");
	}
	
	
	
	// CHECKING DULPICATE BANK ACCOINT WHILE CREATING
	public static int validateDuplicateAccount(int accNo) throws DuplicateAccountException {
		
		BankAccount acc = new BankAccount(accNo);
		
		if(BankAccount.bankAccounts.contains(acc))				
			throw new DuplicateAccountException("Account Number Already Exists!!!");
		
		return accNo;
	}
	
	
	//VALIDATING ACCOUNT TYPE
	public static AccountType validateAccountType(String accType) throws InvalidAccountTypeException
	{		
		for( AccountType a : AccountType.values())
		{
			if(a.name().equals(accType))
				
				return AccountType.valueOf(accType);
		}
			throw new InvalidAccountTypeException("Invalid Account Type Selected...");
		}
	
	//MINIMUM BALANCE CHECK
	public static double validateMinimumBalance(AccountType accType, double amount) throws InsufficientBalanceException
	{
		
		double minBal = accType.getMinimumBalance();
				
		if(amount<minBal)
			throw new InsufficientBalanceException("Minimum Balance requirement for "+accType+" of Rs."+minBal+" is not satisfied.");
		
		return amount;
	}
	
	// SUFFICIENT BALANCE CHECK
	public static boolean validateSufficientBalance(double availBal, double amount, double minBal ) throws InsufficientBalanceException
	{
		
		if(amount>(availBal-minBal))
			throw new InsufficientBalanceException("Insufficient Balance... Your Current Balance Is: "+availBal);
		
		
		return true;
	}
	// VALIDATING PASSWORD 
	public static boolean validatePassword(BankAccount ba, String passwd) throws InvalidPasswdException
	{
		if(passwd.equals(ba.getPasswd()))
			return true;
		else
			throw new InvalidPasswdException("Password you entered is incorrect");
	}
	
}


