package com.litmus7.vrs.dto;

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

	@Override
	public String toString() {
		return "Bike [getBrand()=" + getBrand() + ", getModel()=" + getModel() + ", getRentalPricePerDay()="
				+ getRentalPricePerDay() + ", engineCapacity=" + engineCapacity + ", hasGear=" + hasGear + "]";
	}

}
