package com.app.tester;

import java.util.Scanner;

import com.app.banking.BankAccount;
import com.app.customExceptions.ActiveSessionFoundException;
import com.app.customExceptions.NoActiveSessionFound;
import com.app.utils.ValidationRules;

public class TestAccount {
	//OBJECT FOR CHECKING IF USER HAS LOGGED IN OR NOT.
	private static BankAccount currentSession = null;

	public static void main(String[] args) {
		//ADDING STUBBED DATA TO ARRAYLIST
		SubUtils.addSubUtilData();
		boolean exit = false;

		try(Scanner sc = new Scanner(System.in)){
	
			
		//SHOWING PRIMARY MENU TO CREATE ACCOUNT OR ALREADY HAS AN ACCOUNT
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
					//CREATE ACCOUNT: ONLY PROCEEDS FURTHER IF USER HAS NOT LOGGED IN, THROWS EXCEPTION IF USER IS ALREADY LOGGED IN
					if (TestAccount.currentSession == null) {
						sc.nextLine();
						System.out.println("1- Create New Bank Account. \n\nCreating New Bank Account For You....\n\n");
						BankAccount.createBankAccount(sc);
					} else {
						throw new ActiveSessionFoundException("\nAn Active Session Found...Please Log Out!\n");
					}

					break;
					//DISPLAY ANOTHER MENU IF USER ALREADY HAS AN ACCOUNT
				case 2:
					TestAccount.afterLoginOptions(sc);
					break;

				case 3:
					//EXIT OPTION
					exit = true;
					System.out.println("Thank You For Doing Buisness With Us...");
					break;
				default:
					System.out.println("Invalid Input: Enter Numeric Value input 1, 2 or 3 ");
					break;
				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		}
	}

	
	//SHOW MENU IF USER SELECTS EXISTING CUSTOMER
	static void afterLoginOptions(Scanner sc) throws Exception {
		
		System.out.println("----------------------------------------");
		System.out.println("2- Already existing customer \n");
		System.out.println("     A) Log In");
		System.out.println("     B) View Account Details");
		System.out.println("     C) Deposit Money");
		System.out.println("     D) Withdraw Money");
		System.out.println("     E) Transffer Funds");
		System.out.println("     F) Log Out");
		System.out.print("     Enter your choice: ");

		char choice2 = sc.next().toUpperCase().charAt(0);

		switch (choice2) {

		case 'A':
			//LOG IN OPERATION: CHECKING FIRST USER IS ALREADY LOGGED IN
			if (TestAccount.currentSession != null)
				throw new ActiveSessionFoundException("\nYou are already logged in...!\n");

			System.out.println("     A) Log In");
			System.out.print("Enter Bank Account Number: ");
			//VALIDATING IF INPUT MATCHES WITH EXISTING ACCOUNT NUMBERS
			BankAccount acc = ValidationRules.ifAccountExitsts(new BankAccount(sc.nextInt()));;

			System.out.print("Enter Password: ");
			String passwd = sc.next();
			
			//VALIDATING IF USER HAS ENTERED CORRECT PASSWORD
			if (ValidationRules.validatePassword(acc, passwd))
				TestAccount.currentSession = acc;
			System.out.println("Your Are Sucessfully Logged In...");
			break;

		case 'B':
			//CHECKS IF USER IS ALREADY LOGGED IN
			checkActiveSession();
			System.out.println("\n     A) View Account Details");
			//DISPLAY ACCOUNT DETAILS
			System.out.println(TestAccount.currentSession);
			break;

		case 'C':
			//CHECKS IF USER IS ALREADY LOGGED IN
			checkActiveSession();
			//DEPOSIT AMOUNT
			System.out.println("\n     B) Deposit Money \n");
			System.out.print("Enter Amount to Deposit: ");
			TestAccount.currentSession.depositAmount(sc.nextDouble());
			break;

		case 'D':
			checkActiveSession();
			//WITHDRAW AMOUNT
			System.out.println("\n     C) Withdraw Money");
			System.out.print("Enter Amount to Withdraw: ");
			double withdrawAmount = sc.nextDouble();
			TestAccount.currentSession.withdrawBalance(withdrawAmount);
			break;

		case 'E':
			//CHECKS IF USER IS ALREADY LOGGED IN
			checkActiveSession();
			//TRANSFFER FUNDS
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
			//LOGOUT OPERATION
			System.out.println("     G) Log Out");
			TestAccount.currentSession = null;
			break;

		}

	}



	private static void checkActiveSession() throws NoActiveSessionFound {
		
		if (TestAccount.currentSession == null)
			throw new NoActiveSessionFound("\nYou are not logged in please Log In...\n");
	}

}
