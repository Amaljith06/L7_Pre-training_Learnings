package com.litmus7.vrs;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;
import com.litmus7.vrs.dto.Vehicle;
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
		List<Vehicle> vehicleCatalog = service.loadVehiclesFromFile("vehicles.txt");
		// Print courses using normal loop
		System.out.println("Loaded Vehicles:\n");
		displayVehicles(vehicleCatalog);

		// adding a new car using parameterized constructor
		System.out.println("\nAdding a new Car...");
		Car car1 = new Car("Honda", "Civic", 1400.0, 4, false);
		service.addVehicle(car1);
		System.out.println("\nUpdated Vehicle List:\n");
		displayVehicles(vehicleCatalog);

		// Using default constructor for Car
		System.out.println("\nAdding a new Car...");
		Car car2 = new Car();
		car2.inputDetails();
		service.addVehicle(car2);
//		System.out.println("\nUpdated Vehicle List:\n ");
//		displayVehicles(vehicleCatalog);

		// adding a new bike
		System.out.println("\nAdding a new Bike...");
		Bike bike1 = new Bike("Suzuki", "Gixxer", 600.0, false, 125);
		service.addVehicle(bike1);
//		System.out.println("\nUpdated Vehicle List:\n");
//		displayVehicles(vehicleCatalog);

		// Using default constructor and input for Bike
		System.out.println("\nAdding a new Bike...");
		Bike bike2 = new Bike();
		bike2.inputDetails();
		service.addVehicle(bike2);
		System.out.println("\nUpdated Vehicle List:\n");
		displayVehicles(vehicleCatalog);
	}

	/**
	 * This method displays the available vehicles
	 */
	public static void displayVehicles(List<Vehicle> vehicleCatalog) {
		for (Vehicle vehicle : vehicleCatalog) {
			vehicle.displayDetails();
			System.out.println("------------");
		}
	}

}
