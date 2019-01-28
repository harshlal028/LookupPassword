package com.password.models;

/**
 * 
 * @author harsh
 *
 */
public class Users {

	String name;
	Integer uid;
	Integer gid;
	String comment;
	String home;
	String shell;

	public Users() {
		name = "";
		uid = 0;
		gid = 0;
		comment = "";
		home = "";
		shell = "";
	}

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
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * @param home
	 *            the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * @return the shell
	 */
	public String getShell() {
		return shell;
	}

	/**
	 * @param shell
	 *            the shell to set
	 */
	public void setShell(String shell) {
		this.shell = shell;
	}
}
