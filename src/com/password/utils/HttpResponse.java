package com.password.utils;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class generates custom HTTP response messages used by the API's
 * 
 * @author Harsh
 *
 */
public class HttpResponse implements IResponse {
	public final int SUCCESS = 0;
	public final int FAILURE = 1;
	private static final ObjectMapper mapper = new ObjectMapper();

	private int status;
	private ResponseCodes responseCode;
	private String details;

	private HashMap<String, Object> response;

	public HttpResponse() {
		System.out.println("-------http response is up----------------");
		this.status = SUCCESS;
		this.responseCode = null;
		this.details = null;
	}

	public HttpResponse(int status, ResponseCodes responseCode, String detail) {
		this.status = status;
		this.responseCode = responseCode;
		this.details = detail;
	}

	private HashMap<String, Object> setResponse(int status, ResponseCodes responseCode, String detail) {
		response = new HashMap<String, Object>();
		response.put("status", status);
		response.put("responseCode", responseCode);
		response.put("detail", detail);
		return response;
	}

	@Override
	public ResponseEntity<String> sendResponse(int status, ResponseCodes responseCode, String detail) {

		HttpStatus httpstatus = HttpStatus.ACCEPTED;

		if (status == FAILURE) {
			httpstatus = HttpStatus.NOT_ACCEPTABLE;
		}

		return new ResponseEntity<String>(getJsonResponse(setResponse(status, responseCode, detail)), httpstatus);
	}

	private String getJsonResponse(HashMap<String, Object> obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "JsonProcessingException caught -- Highly Unlikely";
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResponseCodes getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCodes responseCode) {
		this.responseCode = responseCode;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}