package com.app.fruits;

public class Fruit {
	// Properties (instance variables) : color : String , weight : double ,
	// name:String, fresh : boolean
	private String color;
	private double weight;
	private String name;
	private boolean fresh; // default false

	public Fruit(String color, double weight, String name, boolean fresh) {
		super();
		// Added suitable constructors.
		this.color = color;
		this.weight = weight;
		this.name = name;
		this.fresh = fresh;
	}

	// Override toString correctly to return state of all fruits (return only : name
	// ,color , weight )
	public String toString() {
		return "Name of fruit is " + this.name + " and Color is " + this.color + " Weight of it is " + this.weight;
	}

	public String taste() {
		return " No specific Taste ";
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public boolean getFresh() {
		return fresh;
	}

	public double getWeight() {
		return weight;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}

}
