package com.app.fruits;

public class Apple extends Fruit {

	public Apple(double weight, boolean fresh) {
		super("Red", weight, "Apple", fresh);
	}

	public String taste() {
		return " Taste is Sweet and Sour";
	}

	public void jam() {
		System.out.println("The name of fruit is " + this.getName() + " Making jam...");
	}
}
