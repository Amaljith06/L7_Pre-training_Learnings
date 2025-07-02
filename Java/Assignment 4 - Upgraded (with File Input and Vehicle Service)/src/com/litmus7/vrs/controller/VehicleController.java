package com.litmus7.vrs.controller;

import java.util.List;

import com.litmus7.vrs.dto.Response;
import com.litmus7.vrs.dto.Vehicle;
import com.litmus7.vrs.exception.VehicleServiceException;
import com.litmus7.vrs.service.VehicleService;

public class VehicleController {
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int ERROR_STATUS_CODE = 400;

	private VehicleService service = new VehicleService();

	public Response<List<Vehicle>> loadVehiclesFromFile(String filepath) {
		Response<List<Vehicle>> response = new Response<List<Vehicle>>();

		if (filepath == null || filepath.trim().isEmpty()) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("File path is empty");
			response.setPayload(null);
			return response;
		}

		try {
			List<Vehicle> vehicles = service.loadVehicles(filepath);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setPayload(vehicles);

		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Could not load vehicle data" + e.getMessage());
			response.setPayload(null);
		} catch (Exception e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Unexpected error  while loading vehicles: " + e.getMessage());
			response.setPayload(null);
		}
		return response;
	}

	public Response<String> addVehicle(Vehicle vehicle) {
		Response<String> response = new Response<String>();

		if (vehicle == null) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Vehicle input is empty");
			response.setPayload(null);
			return response;
		}

		try {
			String result = service.addVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setPayload(result);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Failed to add vehicle: " + e.getMessage());
			response.setPayload(null);
		}

		return response;
	}

	public Response<List<Vehicle>> getAllVehicles() {
		Response<List<Vehicle>> response = new Response<>();

		try {
			List<Vehicle> vehicles = service.getAllVehicles();
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setPayload(vehicles);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Error retrieving vehicles " + e.getMessage());
			response.setPayload(null);
		}
		return response;
	}

	public Response<Vehicle> searchVehicle(String brand, String model) {
		Response<Vehicle> response = new Response<>();

		if (brand == null || brand.trim().isEmpty() || model == null || model.trim().isEmpty()) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Brand and model must not be empty.");
			response.setPayload(null);
			return response;
		}

		try {
			Vehicle searchResult = service.searchVehicle(brand, model);
			if (searchResult == null) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage("Vehicle not found for brand: " + brand + " and model: " + model);
				response.setPayload(null);
			} else {
				response.setStatusCode(SUCCESS_STATUS_CODE);
				response.setPayload(searchResult);
			}
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Error occurred during search " + e.getMessage());
			response.setPayload(null);
		}

		return response;
	}

	public Response<Double> calculateTotalRentalPrice() {
		Response<Double> response = new Response<>();

		try {
			double total = service.calculateTotalRentalPrice();
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setPayload(total);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Error calculating total rental price " + e.getMessage());
			response.setPayload(0.0);
		}

		return response;
	}
}
