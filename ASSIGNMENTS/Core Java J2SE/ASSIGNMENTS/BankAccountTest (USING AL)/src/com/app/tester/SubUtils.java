package com.app.tester;
import com.app.banking.*;


public class SubUtils {

	
	public static void addSubUtilData()
	{
	BankAccount acc1 = new BankAccount(1001,"Jayesh", AccountType.SAVINGS, 1000000,"06-10-2023", "1234");
	BankAccount acc2 = new BankAccount(1002,"Ashish", AccountType.CURRENT, 1000000,"16-09-2015", "1234");
	BankAccount acc3 = new BankAccount(1003,"Harshad", AccountType.FD, 1000000,"30-10-2023", "1234");
	BankAccount acc4 = new BankAccount(1004,"Divyanshu", AccountType.DEMAT, 1000000,"20-09-2016", "1234");
	BankAccount acc5 = new BankAccount(1005,"Tushar", AccountType.SAVINGS, 1000000,"25-10-2016", "1234");
	
    BankAccount.bankAccounts.add(acc1);
    BankAccount.bankAccounts.add(acc2);
    BankAccount.bankAccounts.add(acc3);
    BankAccount.bankAccounts.add(acc4);
    BankAccount.bankAccounts.add(acc5);

	}
	

}
