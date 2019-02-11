package com.password.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author harsh
 *
 */
public class TestPasswordService {
	
	static IPasswordService obj = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		obj = new PasswordService();
	}
	
	@Test
	public void testGetAllUsers() {
		Assert.assertNotNull(obj.getAllUsers());
	}
	
	@Test
	public void testGetUsers() {
		Assert.assertEquals(obj.getUsers(null, null, null, null, null, null).size(),0);
	}
	
	@Test
	public void testGetUser() {
		Assert.assertEquals(obj.getUser(null),null);
	}
	
	@Test
	public void testGetGroups() {
		Assert.assertEquals(obj.getGroups(null).size(),0);
	}
	
	@Test
	public void getAllGroups() {
		Assert.assertNotNull(obj.getAllGroups());
	}
	
	@Test
	public void testGetGroupsWithParam() {
		Assert.assertEquals(obj.getGroups(null, null, null).size(),0);
	}
	
	@Test
	public void testGetGroup() {
		Assert.assertEquals(obj.getGroup(null),null);
	}

}
