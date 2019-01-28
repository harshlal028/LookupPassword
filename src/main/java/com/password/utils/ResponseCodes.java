package com.password.utils;

/**
 * Enumeration class contains response code constants
 * 
 * @author Harsh
 *
 */
public enum ResponseCodes {

	INVALID_DATA(900), ERROR_DATABASE(901), INTERNAL_ERROR(902), SUCCESS(800), FAILURE(903);

	private int response;

	ResponseCodes(int response) {
		this.response = response;
	}

	public int getResponse() {
		return response;
	}

	public static int valueOf(ResponseCodes arg) {
		return (arg.response);
	}
}