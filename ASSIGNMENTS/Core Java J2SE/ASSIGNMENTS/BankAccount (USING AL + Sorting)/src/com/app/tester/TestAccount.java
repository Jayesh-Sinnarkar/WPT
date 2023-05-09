package com.app.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import com.app.banking.BankAccount;
import com.app.customExceptions.ActiveSessionFoundException;
import com.app.customExceptions.NoActiveSessionFound;
import com.app.utils.DateComparator;
import com.app.utils.ValidationRules;

public class TestAccount {
	// OBJECT FOR CHECKING IF USER HAS ALREADY LOGGED IN.
	private static BankAccount currentSession = null;

	public static void main(String[] args) {
		//ADDING STUBBED DATA
		SubUtils.addSubUtilData();
		boolean exit = false;

		try(Scanner sc = new Scanner(System.in)){
	
		// DISPLAY STANDARD MENU FOR CREATING ACCOUNT OR EXISTING CUSTOMER
		while (!exit) {

			try  {

				System.out.println("-------ACTS CDAC BANK--------");
				System.out.println("1- Create New Bank Account");
				System.out.println("2- Already existing customer");
				System.out.println("3- Exit");
				System.out.println("----------------------------------------");
				System.out.print("Enter your choice: ");

				int choice1 = sc.nextInt();
				switch (choice1) {

				case 1:
					//CREATING NEW ACCOUNT
					//CHECK IF USER HAS ALREADY LOGGED IN: THROW EXCEPTION IF ACTIVE SESSION FOUND
					if (TestAccount.currentSession == null) {
						sc.nextLine();
						System.out.println("1- Create New Bank Account. \n\nCreating New Bank Account For You....\n\n");
						BankAccount.createBankAccount(sc);
					} else {
						throw new ActiveSessionFoundException("\nAn Active Session Found...Please Log Out!\n");
					}

					break;

				case 2:
					//DISPLAY SECOND MENU IF CUSTOMER SELECTS EXISTING CUSTOMERS
					TestAccount.afterLoginOptions(sc);
					break;

				case 3:
					//EXIT 
					exit = true;
					System.out.println("Thank You For Doing Buisness With Us...");
					break;
				default:
					System.out.println("Enter input 1, 2, 3 ");
					break;
				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		}
	}

	//METHOD FOR DISPLAYING SECOND MENU IF CUSTOMER SELECTS EXISTING CUSTOMERS
	static void afterLoginOptions(Scanner sc) throws Exception {
		
		System.out.println("----------------------------------------");
		System.out.println("2- Already existing customer \n");
		System.out.println("     A) Log In");
		System.out.println("     B) View Account Details");
		System.out.println("     C) Deposit Money");
		System.out.println("     D) Withdraw Money");
		System.out.println("     E) Transffer Funds");
		System.out.println("     F) Log Out");
		System.out.println("     G) Sort Bank Accounts As per AccountNumbers");
		System.out.println("     H) Sort Bank Accounts As per Opening Date");
		System.out.println("     I) Sort Bank Accounts As per AccountBalance");
		System.out.println("     J) Iterate Bank Accounts Using List Iterator");




		System.out.print("     Enter your choice: ");

		char choice2 = sc.next().toUpperCase().charAt(0);

		switch (choice2) {

		case 'A':
			//LOG IN OPERATION
			//THROWS EXCEPTION IF USER HAS ALREADY LOGGED IN
			if (TestAccount.currentSession != null)
				throw new ActiveSessionFoundException("\nYou are already logged in...!\n");

			System.out.println("     A) Log In");
			System.out.print("Enter Bank Account Number: ");
			//VALIDATE IF ACCOUNT NUMBER IS ALREADY IN OUT RECORDS
			BankAccount acc = ValidationRules.ifAccountExitsts(new BankAccount(sc.nextInt()));; 

			System.out.print("Enter Password: ");
			String passwd = sc.next();
			//VALIDATE INPUT PASSWORD
			if (ValidationRules.validatePassword(acc, passwd))
				TestAccount.currentSession = acc;
			System.out.println("Your Are Sucessfully Logged In...");
			break;

		case 'B':
			//CHECK IF USER HAS ALREADY LOGGED IN OTHERWISE THROW EXCEPTION
			checkActiveSession();
			System.out.println("\n     A) View Account Details");
			//PRINT USET ACCOUNT DETAILS
			System.out.println(TestAccount.currentSession);
			break;

		case 'C':
			//CHECK IF USER HAS ALREADY LOGGED IN OTHERWISE THROW EXCEPTION
			checkActiveSession();
			System.out.println("\n     B) Deposit Money \n");
			System.out.print("Enter Amount to Deposit: ");
			TestAccount.currentSession.depositAmount(sc.nextDouble());
			break;

		case 'D':
			//CHECK IF USER HAS ALREADY LOGGED IN OTHERWISE THROW EXCEPTION
			checkActiveSession();
			System.out.println("\n     C) Withdraw Money");
			System.out.print("Enter Amount to Withdraw: ");
			double withdrawAmount = sc.nextDouble();
			TestAccount.currentSession.withdrawBalance(withdrawAmount);
			break;

		case 'E':
			//CHECK IF USER HAS ALREADY LOGGED IN OTHERWISE THROW EXCEPTION
			checkActiveSession();
			System.out.println("\n     D) Transffer Funds\n\n");
			System.out.print("Enter amount to transfer: ");
			double transferAmount = sc.nextDouble();
			System.out.print("\nTransferring Rs. "+transferAmount+" From Account#"+TestAccount.currentSession.getAccNumber());
			System.out.print("\nEnter Destination Account Info: \n\n");
			BankAccount destAcc = ValidationRules.ifAccountExitsts(new BankAccount(sc.nextInt()));
			//Invoking fundsTransffer method from BankAccount Class
			TestAccount.currentSession.fundsTransffer(transferAmount, destAcc);
			break;

		case 'F':
			//Log Out Operation
			System.out.println("     G) Log Out");
			TestAccount.currentSession = null;
			System.out.println("Logged out Successfully...");
			break;
			
		case 'G':
			// DISPLAY ALL ACCOUNTS AS PER ASCENDING ORDER OF ACCOUNT NUMBERS
			System.out.println("     F) Printing BankAccounts sorted by Ascending order of Account Numbers");
		    Collections.sort(BankAccount.bankAccounts);
			System.out.println(BankAccount.bankAccounts);

			break;
			
		case 'H':
			// DISPLAY ALL ACCOUNTS AS PER ASCENDING ORDER OF ACCOUNT CREATION DATE
			System.out.println("     H) Sorting BankAccounts As per Opening Date");
			Collections.sort(BankAccount.bankAccounts, new DateComparator());
			System.out.println(BankAccount.bankAccounts);
		break;
		
		case 'I':
			// DISPLAY ALL ACCOUNTS AS PER ASCENDING ORDER OF ACCOUNT BALANCE
			System.out.println("     I) Sort BankAccounts As per AccountBalance");
			
			Collections.sort(BankAccount.bankAccounts, new Comparator<BankAccount>() 
			{
				public int compare(BankAccount acc1,BankAccount acc2)
				{
					Double accBal1 = acc1.getAccountBalance();
					Double accBal2 = acc2.getAccountBalance();
					return accBal1.compareTo(accBal2)  ;
				}
			}
			);
			System.out.println(BankAccount.bankAccounts);
			break;
			
		case 'J':
			//RETRIVING BANK ACCOUNTS USING ITERATOR
			System.out.println("     J) Iterate Bank Accounts Using List Iterator");
			Iterator<BankAccount>  itr=BankAccount.bankAccounts.iterator();
			while(itr.hasNext())
			 System.out.println(itr.next());
			break;
		}

	}


	//METHOD FOR CHECKING IF CUSTOMER HAS ALREADY LOGGED IN: THROWS EXCEPTION IF CUSTOMER HAS NOT LOGGED IN.
	private static void checkActiveSession() throws NoActiveSessionFound {
		
		if (TestAccount.currentSession == null)
			throw new NoActiveSessionFound("\nYou are not logged in please Log In...\n");
	}

}
