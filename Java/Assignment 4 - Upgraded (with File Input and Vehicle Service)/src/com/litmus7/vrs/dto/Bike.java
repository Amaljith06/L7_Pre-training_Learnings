package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * This class represents a bike A subclass that inherits from the vehicle class
 */
public class Bike extends Vehicle {

	private int engineCapacity;
	private boolean hasGear;

	/**
	 * Default Constructor
	 */
	public Bike() {
		hasGear = false;
		engineCapacity = 125;
	}

	/**
	 * Parameterized constructor
	 *
	 * @param brand             the brand of the bike
	 * @param model             the model of the bike
	 * @param rentalPricePerDay the daily rental price of the bike
	 * @param hasGear           true if the bike has gears; false if gearless
	 * @param engineCapacity    the engine capacity of the bike in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * This method gets bike input details from user
	 */
	public void inputDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n---Enter Bike Details---\n");
		super.inputDetails();

		System.out.println("Is it geared? (True/False) : ");
		hasGear = scan.nextBoolean();
		System.out.println("Enter the engine capacity : ");
		engineCapacity = scan.nextInt();
	}

	/**
	 * This displays the bike details
	 */
	public void displayDetails() {
		super.displayDetails();

		System.out.println("Bike is " + (hasGear ? "geared" : "gearless"));
		System.out.println("Engine capacity : " + engineCapacity + " cc");
	}
}
