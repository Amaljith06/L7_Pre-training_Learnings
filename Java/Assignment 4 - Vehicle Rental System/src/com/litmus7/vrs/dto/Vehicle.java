package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * This class represents a generic vehicle available for rent
 */
public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;

	/**
	 * Default constructor
	 */
	public Vehicle() {
		this.brand = "None";
		this.model = "None";
		this.rentalPricePerDay = 0;
	}

	/**
	 * Parameterized constructor
	 *
	 * @param brand             the brand of the vehicle
	 * @param model             the model of the vehicle
	 * @param rentalPricePerDay the daily rental price of the vehicle
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * This method gets vehicle input details from user
	 */
	public void inputDetails() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter brand: ");
		brand = scan.nextLine();
		System.out.println("Enter model: ");
		model = scan.nextLine();
		System.out.println("Enter rental price per day: ");
		rentalPricePerDay = scan.nextDouble();
	}

	/**
	 * This displays the vehicle details
	 */
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price/Day: " + rentalPricePerDay);
	}
}
