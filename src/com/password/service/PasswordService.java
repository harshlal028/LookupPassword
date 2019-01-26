package com.password.service;

import com.password.models.Demo;

public class PasswordService implements IPasswordService {
	
	/* (non-Javadoc)
	 * @see com.password.service.IPasswordService#getDemo()
	 */
	@Override
	public Demo getDemo()
	{
		Demo demo = new Demo();
		demo.setMessage("Welcome to Server");
		demo.setName("John");
		return demo;
	}

}
