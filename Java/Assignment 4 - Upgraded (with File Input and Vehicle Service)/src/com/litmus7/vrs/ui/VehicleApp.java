package com.litmus7.vrs.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vrs.controller.VehicleController;
import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;
import com.litmus7.vrs.dto.Response;
import com.litmus7.vrs.dto.Vehicle;

/**
 * This class represents the main application to manage and display vehicle
 * details
 */
public class VehicleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		VehicleController controller = new VehicleController();

		// Load vehicles
		System.out.println("Loading vehicles from file...\n");
		Response<List<Vehicle>> loadResponse = controller.loadVehiclesFromFile("vehicles.txt");
		if (loadResponse.getStatusCode() == 200) {
			System.out.println("Loaded Vehicles:\n");
			displayVehicles(loadResponse.getPayload());
		} else {
			System.out.println("Error: " + loadResponse.getErrorMessage());
		}

		// Add a new Car (parameterized)
		System.out.println("\nAdding a new Car...");
		Vehicle car1 = new Car("Honda", "Civic", 1400.0, 4, false);
		Response<String> addCarResponse = controller.addVehicle(car1);
		System.out.println(
				addCarResponse.getStatusCode() == 200 ? addCarResponse.getPayload() : addCarResponse.getErrorMessage());

		// Add a new Bike (parameterized)
		System.out.println("\nAdding a new Bike...");
		Vehicle bike1 = new Bike("Suzuki", "Gixxer", 600.0, false, 125);
		Response<String> addBikeResponse = controller.addVehicle(bike1);
		System.out.println(addBikeResponse.getStatusCode() == 200 ? addBikeResponse.getPayload()
				: addBikeResponse.getErrorMessage());

		// Show all available vehicles
		System.out.println("\nCurrent Vehicle List:\n");
		Response<List<Vehicle>> allVehicles = controller.getAllVehicles();
		if (allVehicles.getStatusCode() == 200) {
			displayVehicles(allVehicles.getPayload());
		} else {
			System.out.println("Error: " + allVehicles.getErrorMessage());
		}

		// Search a vehicle
		System.out.println("\nSearching for vehicle: Honda Civic");
		Response<Vehicle> searchResponse = controller.searchVehicle("Honda", "Civic");
		if (searchResponse.getStatusCode() == 200) {
			System.out.println("Vehicle Found:\n" + searchResponse.getPayload());
		} else {
			System.out.println("Search Error: " + searchResponse.getErrorMessage());
		}

		// Calculate total rental price
		System.out.println("\nTotal rental price: ");
		Response<Double> totalResponse = controller.calculateTotalRentalPrice();
		if (totalResponse.getStatusCode() == 200) {
			System.out.println("Total Rental Price (per day): " + totalResponse.getPayload());
		} else {
			System.out.println("Error: " + totalResponse.getErrorMessage());
		}

		scan.close();
	}

	/**
	 * This method displays the available vehicles
	 */
	public static void displayVehicles(List<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
			System.out.println("------------");
		}
	}

}
