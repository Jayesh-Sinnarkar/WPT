/* CORE JAVA ASSIGNMENT: 01 (FRUIT_BASKET)
 * PRN: 085 NAME: JAYESH VIJAY SINNARKAR
 */
package com.app.tester;

import java.util.Scanner;
import com.app.fruits.*;

public class FruitBasket {

	public static void main(String[] args) {
		int fruitCount = 0;
		int option = 0;
		boolean exit = false;
		double weight = 0.0;
		boolean fresh = false;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter basket size: ");
		Fruit[] fruits = new Fruit[sc.nextInt()];
		
		
		//Displaying menu and selecting user choice until user selects 9 to exit.
		while (!exit) {
			System.out.println("\n\n-----MENU----");
			System.out.println("\n" 
					+ "1. Add Mango\n" 
					+ "2. Add Orange\n" 
					+ "3. Add Apple\n"
					+ "4. Display names of all fruits in the basket.\n"
					+ "5. Display name,color,weight , taste of all fresh fruits , in the basket.\n"
					+ "6. Mark a fruit in a basket , as stale(=not fresh)\n" 
					+ "7. Mark all sour fruits stale\n"
					+ "8. Invoke fruit specific functionality (pulp / juice / jam)\n" 
					+ "9. Exit\n ");

			System.out.print("\nSelect an option: ");
			option = sc.nextInt();

			switch (option) {

			case 1:
				if (fruitCount < fruits.length) {
					System.out.print("Enter the weight of Mango: ");
					weight = sc.nextDouble();

					System.out.print("\nEnter if Mango is fresh? Y|N: ");
					String ch = sc.next();

					if (ch.equals("Y") || ch.equals("y") || ch.equals("yes") || ch.equals("Yes")) {
						fresh = true;
					} else if (ch.equals("N") || ch.equals("n") || ch.equals("No") || ch.equals("no")) {
						fresh = false;
					} else {
						System.out.print("Please enter choice in correct format: ");
						ch = sc.next();
					}

					if (fresh == true)
						fruits[fruitCount++] = new Mango(weight, fresh);
					else
						System.out.println("Stale Mango will not be added into the basket");

				} else
					System.out.println("Basket is full...");
				break;

			case 2:
				if (fruitCount < fruits.length) {
					System.out.print("Enter the weight of Orange: ");
					weight = sc.nextDouble();

					System.out.print("\nEnter if Orange is fresh? Y|N: ");
					String choice = sc.next();

					if (choice.equals("Y") || choice.equals("y") || choice.equals("yes") || choice.equals("Yes")) {
						fresh = true;
					} else if (choice.equals("N") || choice.equals("n") || choice.equals("No") || choice.equals("no")) {
						fresh = false;
					} else {
						System.out.print("Please enter choice in correct format: ");
						choice = sc.next();
					}

					if (fresh == true)
						fruits[fruitCount++] = new Orange(weight, fresh);
					else
						System.out.println("Stale Orange will not be added into the basket");

				} else
					System.out.println("Basket is full...");
				break;

			case 3:
				if (fruitCount < fruits.length) {
					System.out.print("Enter the weight of Apple: ");
					weight = sc.nextDouble();

					System.out.print("\nEnter if Apple is fresh? Y|N: ");
					String cho = sc.next();

					if (cho.equals("Y") || cho.equals("y") || cho.equals("yes") || cho.equals("Yes")) {
						fresh = true;
					} else if (cho.equals("N") || cho.equals("n") || cho.equals("No") || cho.equals("no")) {
						fresh = false;
					} else {
						System.out.print("Please enter choice in correct format: ");
						cho = sc.next();
					}

					if (fresh == true)
						fruits[fruitCount++] = new Apple(weight, fresh);
					else
						System.out.println("Stale Apple will not be added into the basket");
				} else
					System.out.println("Basket is full...");
				break;

			case 4:
				System.out.print("\nFruits in the basket are: ");
				for (Fruit f : fruits) {
					System.out.print(f.getName() + ", ");
				}
				System.out.println();
				break;

			case 5:
				System.out.println("Fruits in the basket are: ");
				for (Fruit f : fruits) {
					System.out.println(f + f.taste());
				}
				break;

			case 6:
				System.out.print("Mark a fruit in a basket as stale. Please enter index of fruit in basket :");
				int choi = sc.nextInt();

				if (fruitCount < choi)
					System.out.println("There are less than " + choi + " fruits in backet.");
				fruits[choi - 1].setFresh(false);
				break;

			case 7:
				System.out.println("All sour fruits are marked as stale: ");
				for (Fruit f : fruits) {
					if (f.taste().equals(" Taste is Sour")) {
						System.out.print("\nMarked as stale: " + f.getName());
						f.setFresh(false);
					}

				}
				break;

			case 8:
				System.out.println("Invoke fruit specific functionality. Enter Index: ");
				int ind = sc.nextInt();

				if (fruits[ind - 1] instanceof Mango)
					((Mango) fruits[ind - 1]).pulp();
				else if (fruits[ind - 1] instanceof Apple)
					((Apple) fruits[ind - 1]).jam();
				else
					((Orange) fruits[ind - 1]).juice();

				break;

			case 9:
				exit = true;
				break;

			default:
				System.out.println("Invalid option: ");
				break;
			}
		}
		sc.close();
	}

}
