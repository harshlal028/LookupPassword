package com.password.service;

import java.util.List;

import com.password.models.Groups;
import com.password.models.Users;

/**
 * 
 * @author harsh
 *
 */
public interface IPasswordService {

	List<Users> getAllUsers();

	List<Users> getUsers(String name, Integer uid, Integer gid, String comment, String home, String shell);

	Users getUser(Integer uid);

	List<Groups> getGroups(Integer uid);

	List<Groups> getAllGroups();

	List<Groups> getGroups(String name, Integer gid, List<String> members);

	Groups getGroup(Integer gid);
}