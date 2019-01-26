package com.password.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.password.models.Demo;
import com.password.service.IPasswordService;
import com.password.utils.IResponse;

@ControllerAdvice
@Controller
public class PasswordController {
	
	@Autowired(required = true)
	protected IResponse respHandle;

	@Autowired(required = true)
	protected IPasswordService serviceObj;

	@Autowired
	protected ApplicationContext context;

	/* Defining Logger for Logging messages */
	private static final Logger logger = Logger.getLogger(PasswordController.class.getName());

	/* Constructor */
	public PasswordController() {
		System.out.println("=================================! Controller is UP !======================================");
	}
	
	@RequestMapping(value = "/demo", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Demo getAllPlaces() {
		logger.info("Inside getAllPlaces");
		Demo demo = null;
		demo = serviceObj.getDemo();
		logger.info("Exiting getAllPlaces");
		return demo;
	}

}
