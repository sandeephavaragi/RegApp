/**
 * This the model entity for the User details used in the registration
 */
package com.sh.app.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author SHavara1
 * 
 */
@Entity
@NamedQuery(name="UserDetails.byName", query="from UserDetails where username = ?")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	@Column (name = "USER_NAME")
	private String username =null;
	@Column (name ="PASSWORD")
	private String password = null;
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
