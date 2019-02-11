package com.password.controller;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.password.service.PasswordService;
import com.password.utils.HttpResponse;

/**
 * 
 * @author harsh
 *
 */
public class TestPasswordController {
	
	static PasswordController obj = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		obj = new PasswordController();
		obj.setRespHandle(new HttpResponse());
		obj.setServiceObj(new PasswordService());
	}
	
	@Test
	public void testGetAllUsers() {
		Assert.assertNotNull(obj.getAllUsers());
	}
	
	@Test
	public void testGetAllUsersWithParam() {
		Assert.assertEquals(obj.getAllUsers(null, null, null, null, null, null).size(),0);
	}
	
	@Test(expected = Exception.class)
	public void testGetUser() throws Exception {
		obj.getUser(null);
	}
	
	@Test
	public void testGetGroupWithUid() {
		Assert.assertEquals(obj.getGroup(null).size(),0);
	}
	
	@Test
	public void testGetGroups() {
		Assert.assertNotNull(obj.getGroups());
	}
	
	@Test
	public void testGetGroupsWithParam() {
		Assert.assertEquals(obj.getGroups(null, null, null).size(),0);
	}
	
	@Test
	public void testGetGroupwithGid() {
		Assert.assertEquals(obj.getGroup(null).size(),0);
	}

}
