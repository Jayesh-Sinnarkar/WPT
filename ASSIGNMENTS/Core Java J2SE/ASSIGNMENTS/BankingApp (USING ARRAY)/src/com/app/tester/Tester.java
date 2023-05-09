package com.app.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.app.banking.BankAccount;

public class Tester {

	public static void main(String[] args) {
		/* 
		Accept 2 account information from user.
		Display 
		Account summary
		Perform : Withdraw
		Deposit
		Funds Transfer
		*/
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)){
			BankAccount[] acc = new BankAccount[2];
			
			acc[0] = new BankAccount(125, "Rajesh", "Savings", 50000, LocalDate.now());
			acc[1] = new BankAccount(126, "Vijay", "Savings", 20000, LocalDate.now());
			
			int accountIndex = 0;
			int secondAccIndex = 0;
			final int ACCOUNT_ONE = 0;
			final int ACCOUNT_TWO = 1;
			
			// switch-case for 2 accounts
			System.out.println("Please select an account:\n"
					+ "1. Rajesh's account\n"
					+ "2. Vijay's account");
			switch (sc.nextInt()) {
			case 1:
				accountIndex = ACCOUNT_ONE;
				secondAccIndex = ACCOUNT_TWO;
				break;
				
			case 2:
				accountIndex = ACCOUNT_TWO;
				secondAccIndex = ACCOUNT_ONE;
				break;

			default:
				System.out.println("Invalid value");
				break;
			}

			// MENU to Display & Operations to Perform
			while(!exit) {
				try {
					System.out.println("1. Display Account Summary\n");
					System.out.println( "2. Withdraw Money\n");
					System.out.println( "3. Deposit Money\n");
					System.out.println("4. Fund Transfer\n");
					System.out.println( "0. Exit");
					
					switch (sc.nextInt()) {
						case 1:
							System.out.println(acc[accountIndex]);
							break;
						
						case 2:
							System.out.println("Enter the amount to withdraw");
							double amount = sc.nextDouble();
							acc[accountIndex].withdraw(amount);
							break;
						case 3:
							System.out.println("Enter the amount to deposit");
							amount = sc.nextDouble();
							acc[accountIndex].deposit(amount);
							break;
						case 4:
							System.out.println("Enter the amount to transfer");
							amount = sc.nextDouble();
							acc[accountIndex].fundTransfer(amount, acc[secondAccIndex]);
							break;
							
						case 0:
							exit = true;
							System.out.println("Thank You For Doing Buisness With Us!");
							break;
	
						default:
							System.out.println("You Have Entered Invalid Input");
							break;
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("---------------------------------------");
			}
		}
	}

}
