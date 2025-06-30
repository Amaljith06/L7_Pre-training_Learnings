package com.litmus7.vrs.dto;

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

	@Override
	public String toString() {
		return "Car [getBrand()=" + getBrand() + ", getModel()=" + getModel() + ", getRentalPricePerDay()="
				+ getRentalPricePerDay() + "numberOfDoors=" + numberOfDoors + ", isAutomatic=" + isAutomatic + "]";
	}

}
