package com.password.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.password.models.Groups;
import com.password.models.Users;
import com.password.utils.FileReadUtility;

/**
 * 
 * @author harsh
 *
 */
public class PasswordService implements IPasswordService {

	long userListModified = 0;
	long groupListModified = 0;

	List<Users> userList = new ArrayList<>();
	List<Groups> groupList = new ArrayList<>();
	FileReadUtility fileRead = new FileReadUtility();

	private void reloadList() {
		String passwordFile = fileRead.getPasswordFile();
		Path path = null;
		long currentTime = 0;
		try {
			if (passwordFile != null)
				path = Paths.get(passwordFile);
			currentTime = Files.getLastModifiedTime(path).toMillis();
			if (currentTime > userListModified) {
				userList = fileRead.reloadUsers(passwordFile);
				userListModified = currentTime;
			}
		} catch (Exception e) {
			userList.clear();
		}

		String groupFile = fileRead.getGroupFile();
		try {
			if (groupFile != null)
				path = Paths.get(groupFile);
			currentTime = Files.getLastModifiedTime(path).toMillis();
			if (currentTime > groupListModified) {
				groupList = fileRead.reloadGroups(groupFile);
				groupListModified = currentTime;
			} 
		} catch (Exception e) {
			groupList.clear();
		}
	}

	@Override
	public List<Users> getAllUsers() {
		this.reloadList();
		return userList;
	}

	@Override
	public List<Users> getUsers(String name, Integer uid, Integer gid, String comment, String home, String shell) {
		this.reloadList();
		List<Users> uList = new ArrayList<>();
		for (Users users : userList) {
			if ((name == null || users.getName().equals(name)) && (uid == null || users.getUid().equals(uid))
					&& (gid == null || users.getGid().equals(gid))
					&& (comment == null || users.getComment().equals(comment))
					&& (home == null || users.getHome().equals(home))
					&& (shell == null || users.getShell().equals(shell))) {
				uList.add(users);
			}
		}
		return uList;
	}

	@Override
	public Users getUser(Integer uid) {
		this.reloadList();
		for (Users user : userList) {
			if (user.getUid().equals(uid))
				return user;
		}
		return null;
	}

	@Override
	public List<Groups> getGroups(Integer uid) {
		this.reloadList();
		List<Integer> gidList = new ArrayList<>();
		for (Users user : userList) {
			if (user.getUid().equals(uid))
				gidList.add(user.getGid());
		}

		List<Groups> gList = new ArrayList<>();
		for (Groups groups : gList) {
			if (gidList.contains(groups.getGid()))
				gList.add(groups);
		}
		return gList;
	}

	@Override
	public List<Groups> getAllGroups() {
		this.reloadList();
		return groupList;
	}

	@Override
	public List<Groups> getGroups(String name, Integer gid, List<String> members) {
		this.reloadList();
		List<Groups> gList = new ArrayList<>();
		for (Groups groups : groupList) {
			if ((name == null || groups.getName().equals(name)) && (gid == null || groups.getGid().equals(gid))
					&& (members == null || groups.getMembers().containsAll(members))) {
				gList.add(groups);
			}
		}
		return gList;
	}

	@Override
	public Groups getGroup(Integer gid) {
		this.reloadList();
		for (Groups group : groupList) {
			if (group.getGid().equals(gid))
				return group;
		}
		return null;
	}
}
