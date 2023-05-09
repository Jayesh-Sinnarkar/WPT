package com.app.fruits;

public class Mango extends Fruit {

	public Mango(double weight, boolean fresh) {
		super("Yellow", weight, "Mango", fresh);
	}

	public String taste() {
		return " Taste is Sweet ";
	}

	public void pulp() {
		System.out.println(
				"The name of fruit is " + this.getName() + " & the colour is " + this.getColor() + " Creating pulp...");
	}
}
