package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * This class represents a car A subclass that inherits from the vehicle class
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default Constructor
	 */
	public Car() {
		this.numberOfDoors = 4;
		this.isAutomatic = false;
	}

	/**
	 * Parameterized constructor
	 *
	 * @param brand             the brand of the car
	 * @param model             the model of the car
	 * @param rentalPricePerDay the daily rental price of the car
	 * @param numberOfDoors     the number of doors in the car
	 * @param isAutomatic       true if the car is automatic; false if manual
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * This method gets car input details from user
	 */
	public void inputDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n---Enter Car Details---\n");
		super.inputDetails();

		System.out.println("Enter number of doors : ");
		numberOfDoors = scan.nextInt();
		System.out.println("Is the car automatic? (True/False) : ");
		isAutomatic = scan.nextBoolean();
	}

	/**
	 * This displays the car details
	 */
	public void displayDetails() {
		System.out.println("\n---Displaying Car Details---\n");
		super.displayDetails();
		System.out.println("Number of doors : " + numberOfDoors);
		System.out.println("Car is " + (isAutomatic ? "automatic" : "manual"));
	}
}
