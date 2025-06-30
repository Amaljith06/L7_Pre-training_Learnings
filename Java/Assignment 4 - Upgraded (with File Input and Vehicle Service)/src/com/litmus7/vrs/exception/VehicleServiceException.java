package com.litmus7.vrs.exception;

/**
 * Exception thrown when data access operations fail.
 */
public class VehicleServiceException extends Exception {

	public VehicleServiceException(String message) {
		super(message);
	}

	public VehicleServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
