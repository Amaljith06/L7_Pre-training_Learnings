package com.litmus7.vrs.dto;

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

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

}
