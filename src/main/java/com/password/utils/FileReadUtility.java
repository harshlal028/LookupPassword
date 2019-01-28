package com.password.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.password.models.Groups;
import com.password.models.Users;

public class FileReadUtility {

	private Groups parseGroup(String groupLine) {
		Groups group = null;
		if (groupLine == null || groupLine.trim().isEmpty()) {
			return group;
		}

		String line = groupLine.trim();
		String[] parts = line.split(":");
		if (parts.length < 3) {
			return group;
		}

		try {
			String name;
			Integer gid;
			List<String> members;

			name = parts[0];
			gid = Integer.parseInt(parts[2]);

			if (parts.length == 4) {
				members = Arrays.asList(parts[3].split(","));
			} else {
				members = Collections.emptyList();
			}

			group = new Groups(name, gid, members);
		} catch (final Exception ex) {
			System.out.println("Error while parsing group");
		}
		return group;
	}

	private Users parseUser(String userLine) {
		Users user = null;
		if (userLine == null || userLine.trim().isEmpty()) {
			return user;
		}

		String line = userLine.trim();
		String[] parts = line.split(":");
		if (parts.length < 7) {
			return user;
		}

		try {
			String name;
			Integer uid;
			Integer gid;
			String comment;
			String home;
			String shell;

			name = parts[0];
			uid = Integer.parseInt(parts[2]);
			gid = Integer.parseInt(parts[3]);
			comment = parts[4];
			home = parts[5];
			shell = parts[6];
			user = new Users(name, uid, gid, comment, home, shell);
		} catch (final Exception ex) {
			System.out.println("Error while parsing user");
		}
		return user;
	}

	public List<Groups> reloadGroups(String filename) throws FileNotFoundException, IOException {
		List<Groups> groupList = new ArrayList<>();
		Groups group = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine();
			while (line != null) {
				group = parseGroup(line);
				if (group != null)
					groupList.add(group);
				line = br.readLine();
			}
		}
		return groupList;
	}

	public List<Users> reloadUsers(String filename) throws FileNotFoundException, IOException {
		List<Users> userList = new ArrayList<>();
		Users user = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine();
			while (line != null) {
				user = parseUser(line);
				if (user != null)
					userList.add(user);
				line = br.readLine();
			}
		}
		return userList;
	}

	public String getGroupFile() {
		String default_file = "/etc/groups";
		String current_file = System.getenv("GROUP_FILE");
		try {
			if (current_file != null && new File(current_file).isFile()) {
				return current_file;
			} else if (new File(default_file).isFile()) {
				return default_file;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPasswordFile() {
		String default_file = "/etc/passwd";
		String current_file = System.getenv("PASSWORD_FILE");
		try {
			if (current_file != null && new File(current_file).isFile()) {
				return current_file;
			} else if (new File(default_file).isFile()) {
				return default_file;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public static void main(String[] args) throws FileNotFoundException,
	 * IOException { FileReadUtility obj = new FileReadUtility(); List<Users> u =
	 * obj.reloadUsers("password.txt"); List<Groups> g =
	 * obj.reloadGroups("group.txt"); System.out.println(u.size()+" == "+g.size());
	 * String javaHome = System.getenv("PATH"); System.out.println(javaHome); }
	 */

}
