package com.app.fruits;

public class Orange extends Fruit {

	public Orange(double weight, boolean fresh) {
		super("Orange", weight, "Orange", fresh);
	}

	public String taste() {
		return " Taste is Sour";
	}

	public void juice() {
		System.out.println("The name of fruit is " + this.getName() + " & the weight is " + this.getWeight()
				+ " Extracting Juice...");
	}
}
