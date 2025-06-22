package com.litmus7.vrs;

import java.util.Scanner;

import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;

/**
 * This class represents the main application to manage and display vehicle
 * details
 */
public class VehicleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Using parameterized Constructor
		Car car1 = new Car("Honda", "Civic", 1400.0, 4, false);
		car1.displayDetails();

		// Using default constructor for Car
		Car car2 = new Car();
		car2.inputDetails();
		car2.displayDetails();

		// Parameterized Bike
		Bike bike1 = new Bike("Suzuki", "Gixxer", 600.0, false, 125);
		bike1.displayDetails();

		// Using default constructor and input for Bike
		Bike bike2 = new Bike();
		bike2.inputDetails();
		bike2.displayDetails();
	}

}
