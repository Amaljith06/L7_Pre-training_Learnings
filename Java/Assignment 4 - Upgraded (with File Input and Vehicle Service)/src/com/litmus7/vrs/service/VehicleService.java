package com.litmus7.vrs.service;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.vrs.dao.VehicleFileDao;
import com.litmus7.vrs.dto.Vehicle;
import com.litmus7.vrs.exception.VehicleDataAccessException;
import com.litmus7.vrs.exception.VehicleServiceException;

/**
 * This class represents a service layer
 */
public class VehicleService {

	private List<Vehicle> vehicles = new ArrayList<>();
	private VehicleFileDao vehicleFileDao = new VehicleFileDao();

	/**
	 * Load all vehicles from file
	 * 
	 * @param filepath
	 * @return vehicles
	 */
	public List<Vehicle> loadVehicles(String filepath) throws VehicleServiceException {
		try {
			vehicles = vehicleFileDao.loadVehiclesFromFile(filepath);
			return vehicles;
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException("\nFailed to load vehicles from file: " + e.getMessage(), e);
		} catch (Exception e) {
			throw new VehicleServiceException("\nUnexpected error while loading vehicles: " + e.getMessage(), e);
		}
	}

	/**
	 * This method adds a new vehicle to the list of available vehicles
	 * 
	 * @param vehicle the new vehicle to be added
	 */
	public String addVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (!vehicles.contains(vehicle)) {
			vehicles.add(vehicle);
			return "Vehicle added successfully: " + vehicle.getBrand() + " " + vehicle.getModel();
		}
		throw new VehicleServiceException("Vehicle already exists");
	}

	/**
	 * Get all available vehicles
	 * 
	 * @return vehicles
	 */
	public List<Vehicle> getAllVehicles() throws VehicleServiceException {
		try {
			return vehicles;
		} catch (Exception e) {
			throw new VehicleServiceException("\nFailed to retrieve vehicle list: " + e.getMessage(), e);
		}
	}

	/**
	 * Search for a vehicle by brand and model
	 * 
	 * @return vehicle
	 */
	public Vehicle searchVehicle(String brand, String model) throws VehicleServiceException {
		try {
			for (Vehicle v : vehicles) {
				if (v.getBrand().equalsIgnoreCase(brand) && v.getModel().equalsIgnoreCase(model)) {
					return v;
				}
			}
			return null;
		} catch (Exception e) {
			throw new VehicleServiceException("\nSearch failed: " + e.getMessage(), e);
		}
	}

	/**
	 * Calculate the total rental price per day for all vehicles
	 * 
	 * @return total
	 */
	public double calculateTotalRentalPrice() throws VehicleServiceException {
		try {
			double total = 0;
			for (Vehicle v : vehicles) {
				total += v.getRentalPricePerDay();
			}
			return total;
		} catch (Exception e) {
			throw new VehicleServiceException("/nFailed to calculate total rental price: " + e.getMessage(), e);
		}
	}
}
