package com.litmus7.vrs.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;
import com.litmus7.vrs.dto.Vehicle;
import com.litmus7.vrs.exception.VehicleDataAccessException;

public class VehicleFileDao {

	/**
	 * This method read vehicle data from a text file and load them into a List
	 * 
	 * @param filepath
	 * @return vehicles
	 */
	public List<Vehicle> loadVehiclesFromFile(String filepath) throws VehicleDataAccessException {
		List<Vehicle> vehicles = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					switch (parts[0]) {
					case "Car":
						Car car = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
						vehicles.add(car);
						break;
					case "Bike":
						Bike bike = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
						vehicles.add(bike);
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
		} catch (IOException e) {
			throw new VehicleDataAccessException("Error reading vehicle file: " + e.getMessage(), e);
		}
		return vehicles;
	}
}
