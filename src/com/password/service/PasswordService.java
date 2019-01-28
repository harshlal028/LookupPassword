package com.password.service;

import java.util.ArrayList;
import java.util.List;

import com.password.models.Groups;
import com.password.models.Users;

/**
 * 
 * @author harsh
 *
 */
public class PasswordService implements IPasswordService {

	@Override
	public List<Users> getAllUsers() {
		List<Users> userList = new ArrayList<>();
		Users users = new Users();
		users.setName("HARSH");
		userList.add(users);
		return userList;
	}

	@Override
	public List<Users> getUsers(String name, Integer uid, Integer gid, String comment, String home, String shell) {
		List<Users> userList = new ArrayList<>();
		Users users = new Users();
		users.setName("HARSH");
		userList.add(users);
		return userList;
	}

	@Override
	public Users getUser(Integer uid) {
		Users users = new Users();
		users.setName("HARSH");
		return users;
	}

	@Override
	public List<Groups> getGroups(Integer uid) {
		List<Groups> groupList = new ArrayList<>();
		Groups groups = new Groups();
		groups.setName("HARSH");
		return groupList;
	}

	@Override
	public List<Groups> getAllGroups() {
		List<Groups> groupList = new ArrayList<>();
		Groups groups = new Groups();
		groups.setName("HARSH");
		return groupList;
	}

	@Override
	public List<Groups> getGroups(String name, Integer gid, List<String> members) {
		List<Groups> groupList = new ArrayList<>();
		Groups groups = new Groups();
		groups.setName("HARSH");
		return groupList;
	}

	@Override
	public Groups getGroup(Integer gid) {
		Groups groups = new Groups();
		groups.setName("HARSH");
		return groups;
	}
}
