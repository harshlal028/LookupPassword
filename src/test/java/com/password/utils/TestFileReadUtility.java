package com.password.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFileReadUtility {

	static FileReadUtility obj = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		obj = new FileReadUtility();
	}

	@Test
	public void testNonEmptyParseGroup() {
		Assert.assertNull(obj.getGroupFile());
		Assert.assertNull(obj.getPasswordFile());
	}
	
	@Test
	public void testParseUser() throws FileNotFoundException, IOException {
		Assert.assertEquals(obj.reloadUsers("src/test/java/com/password/utils/password").size(),6);
	}
	
	@Test
	public void testParseGroup() throws FileNotFoundException, IOException {
		Assert.assertEquals(obj.reloadGroups("src/test/java/com/password/utils/group").size(),2);
	}
	

}
