package com.example.yaron.practicep.Entities;

import com.google.gson.Gson;

/**
 * Custom user object class designed for handling all user related data
 */
public class User {

	private Integer userID;
	
	private String name;
	
	private String email;
	
	private String password;
	
	public User() {
		this.name = "";
		this.email = "";
		this.password = "";
	}
	
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toJson() {
		Gson gson = new Gson();
        return gson.toJson(this);
	}
	
}
