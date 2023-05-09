package com.assignment2.tester;

import com.assignment2.stack.*;
import com.assignment2.customer.Customer;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			boolean exit = false;
			boolean fixedStack = false;
			boolean growableStack = false;
			
			Stack customerStack = null;	//can cause NullPointerException?
				// apply exception handling
			while(!exit) {
				System.out.println("----------- TestStack -----------");
				System.out.println("1. Fixed Stack\n" +
									"2. Growable Stack\n" +
									"3. Push Data\n" +
									"4. Pop Data and Display\n" +
									"5. Exit");
				System.out.print("Selection : ");
				switch(sc.nextInt()) {
					case 1:
						System.out.println("---------------------------------");
						if(!growableStack) {
							fixedStack = true;
							customerStack = new FixedStack();
							growableStack = true;
							System.out.println("Fixed Stack chosen!");
						}
						break;
						
					case 2:
						System.out.println("---------------------------------");
						if(!fixedStack) {
							growableStack = true;
							customerStack = new GrowableStack();
							fixedStack = true;
							System.out.println("Growable Stack chosen!");
						}
						break;
						
					case 3:
						System.out.println("---------------------------------");
						if(fixedStack || growableStack) {
							//push data
							System.out.println("Enter customer details : name address ");
							Customer c = new Customer(sc.next(), sc.next());
							customerStack.push(c);
						} else {
							System.out.println("Please select a stack!");
						}
						break;
						
					case 4:
						System.out.println("---------------------------------");
						if(fixedStack || growableStack) {
							//pop data
							Customer c = customerStack.pop();
							if(c != null)
								System.out.println(c);	
						} else {
							System.out.println("Please select a stack!");
						}
						break;
						
					case 5:
						System.out.println("---------------------------------");
						exit = true;
						System.out.println("Exited!");
						break;
						
					default:
						System.out.println("Invalid selection.");
						break;
				}
			}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
