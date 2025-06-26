package com.litmus7.vrs.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;
import com.litmus7.vrs.dto.Vehicle;

/**
 * This class represents a service layer
 */
public class VehicleService {

	private List<Vehicle> vehicleCatalog = new ArrayList<>();

	/**
	 * This method read vehicle data from a text file and load them into a List
	 * 
	 * @param filepath
	 */
	public List<Vehicle> loadVehiclesFromFile(String filepath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					if (parts[0].equalsIgnoreCase("Car")) {
						Car car = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
						vehicleCatalog.add(car);
					} else if (parts[0].equalsIgnoreCase("Bike")) {
						Bike bike = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
						vehicleCatalog.add(bike);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading vehicle file: " + e.getMessage());
		}
		return vehicleCatalog;
	}

//	/**
//	 * This method returns the list of available vehicles
//	 * 
//	 * @return vehicleCatalog the list of available vehicles
//	 */
//	public List<Vehicle> getVehicleCatalog() {
//		return vehicleCatalog;
//	}

	/**
	 * This method adds a new vehicle to the list of available vehicles
	 * 
	 * @param vehicle the new vehicle to be added
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicleCatalog.add(vehicle);

	}
}
