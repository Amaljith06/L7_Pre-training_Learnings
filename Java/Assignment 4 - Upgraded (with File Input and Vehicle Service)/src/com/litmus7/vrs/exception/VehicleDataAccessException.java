package com.litmus7.vrs.exception;

public class VehicleDataAccessException extends Exception {

	private static final int n=0;
	public VehicleDataAccessException(String message) {
		super(message);
	}

	public VehicleDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
