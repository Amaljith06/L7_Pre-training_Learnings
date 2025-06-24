package com.litmus7.vrs;

import java.util.Scanner;

import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;
import com.litmus7.vrs.service.VehicleService;

/**
 * This class represents the main application to manage and display vehicle
 * details
 */
public class VehicleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		VehicleService service = new VehicleService();
		// Load vehicle data from file
		service.loadVehiclesFromFile("vehicles.txt");
		// Print courses using normal loop
		System.out.println("Loaded Vehicles:\n");
		service.displayVehicles();

		// adding a new car using parameterized constructor
		System.out.println("\nAdding a new Car...");
		Car car1 = new Car("Honda", "Civic", 1400.0, 4, false);
		service.addVehicle(car1);
		System.out.println("\nUpdated Vehicle List:\n");
		service.displayVehicles();

		// Using default constructor for Car
		System.out.println("\nAdding a new Car...");
		Car car2 = new Car();
		car2.inputDetails();
		service.addVehicle(car2);
//		System.out.println("\nUpdated Vehicle List:\n ");
//		service.displayVehicles();

		// adding a new bike
		System.out.println("\nAdding a new Bike...");
		Bike bike1 = new Bike("Suzuki", "Gixxer", 600.0, false, 125);
//		System.out.println("\nUpdated Vehicle List:\n");
//		service.addVehicle(bike1);

		// Using default constructor and input for Bike
		System.out.println("\nAdding a new Bike...");
		Bike bike2 = new Bike();
		bike2.inputDetails();
		service.addVehicle(bike2);
		System.out.println("\nUpdated Vehicle List:\n");
		service.displayVehicles();
	}

}
