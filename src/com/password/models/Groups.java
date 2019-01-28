package com.password.models;

import java.util.List;

/**
 * 
 * @author harsh
 *
 */
public class Groups {

	String name;
	Integer gid;
	List<String> members;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gid
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * @param gid
	 *            the gid to set
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * @return the members
	 */
	public List<String> getMembers() {
		return members;
	}

	/**
	 * @param members
	 *            the members to set
	 */
	public void setMembers(List<String> members) {
		this.members = members;
	}
}
