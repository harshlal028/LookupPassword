package com.password.utils;

import org.springframework.http.ResponseEntity;

/**
 * Interface used to return HttpResponse status and codes.
 * 
 * @author harsh
 *
 */
public interface IResponse {
	public final int SUCCESS = 0;
	public final int FAILURE = 1;

	/**
	 * Method to send Http Response
	 * 
	 * @param status
	 *            - response status code
	 * @param responseCode
	 * @param detail
	 *            - Message String
	 * @return - JSON String
	 */
	public ResponseEntity<String> sendResponse(int status, ResponseCodes responseCode, String detail);

}