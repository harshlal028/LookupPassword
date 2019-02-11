package com.password.utils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author harsh
 *
 */
public class TestHttpResponse {
	
	static HttpResponse obj = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		obj = new HttpResponse();
	}

	@Test
	public void testSendResponseFail() {
		ResponseEntity<String> res = obj.sendResponse(1, null, null);
		Assert.assertEquals(res.getStatusCode(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@Test
	public void testSendResponseNotFound() {
		ResponseEntity<String> res = obj.sendResponse(2, null, null);
		Assert.assertEquals(res.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void testSendResponseSuccess() {
		ResponseEntity<String> res = obj.sendResponse(0, null, null);
		Assert.assertEquals(res.getStatusCode(),HttpStatus.ACCEPTED);
	}

}
