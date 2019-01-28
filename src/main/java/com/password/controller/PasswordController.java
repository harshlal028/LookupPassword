package com.password.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.password.models.Groups;
import com.password.models.Users;
import com.password.service.IPasswordService;
import com.password.utils.IResponse;
import com.password.utils.ResponseCodes;

/**
 * 
 * @author harsh
 *
 */
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
		System.out.println("===================! Controller is UP !===================");
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<String> Exception(Exception e) {
		return RaiseNotFoundError(e.getMessage());
	}

	protected ResponseEntity<String> RaiseNotFoundError(String message) {
		return respHandle.sendResponse(IResponse.NOT_FOUND, ResponseCodes.INTERNAL_ERROR, message);
	}

	/**
	 * Return a list of all users on the system, as defined in the /etc/passwd file.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Users> getAllUsers() {
		List<Users> userList = serviceObj.getAllUsers();
		return userList;
	}

	/**
	 * Return a list of users matching all of the specified query fields. Only exact
	 * matches need to be supported.
	 * 
	 * @param name
	 * @param uid
	 * @param gid
	 * @param comment
	 * @param home
	 * @param shell
	 * @return
	 */
	@RequestMapping(value = "/users/query", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Users> getAllUsers(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "uid", required = false) Integer uid,
			@RequestParam(value = "gid", required = false) Integer gid,
			@RequestParam(value = "comment", required = false) String comment,
			@RequestParam(value = "home", required = false) String home,
			@RequestParam(value = "shell", required = false) String shell) {
		List<Users> userList = serviceObj.getUsers(name, uid, gid, comment, home, shell);
		return userList;

	}

	/**
	 * Return a single user with <uid>. Return 404 if <uid> is not found.
	 * 
	 * @param uid
	 * @return
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "/users/{uid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Users getUser(@PathVariable("uid") Integer uid) throws java.lang.Exception {
		Users user = serviceObj.getUser(uid);
		if (user == null)
			throw new java.lang.Exception("Content not found");
		return user;
	}

	/**
	 * Return all the groups for a given user.
	 * 
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/users/{uid}/groups", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Groups> getGroup(@PathVariable("uid") Integer uid) {
		List<Groups> groupList = serviceObj.getGroups(uid);
		return groupList;
	}

	/**
	 * Return a list of all groups on the system, a defined by /etc/group.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/groups", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Groups> getGroups() {
		List<Groups> groupList = serviceObj.getAllGroups();
		return groupList;
	}

	/**
	 * Return a list of groups matching all of the specified query fields.
	 * 
	 * @param name
	 * @param gid
	 * @param members
	 * @return
	 */
	@RequestMapping(value = "/groups/query", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Groups> getGroups(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "gid", required = false) Integer gid,
			@RequestParam(value = "member", required = false) List<String> members) {
		List<Groups> groupList = serviceObj.getGroups(name, gid, members);
		return groupList;
	}

	/**
	 * Return a single group with <gid>. Return 404 if <gid> is not found.
	 * 
	 * @param gid
	 * @return
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "/groups/{gid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Groups getGroups(@PathVariable("gid") Integer gid) throws java.lang.Exception {
		Groups group = serviceObj.getGroup(gid);
		if (group == null)
			throw new java.lang.Exception("Content not found");
		return group;
	}

}
