package com.luka.anirest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class LoginUser {

	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@NotEmpty(message = "It's not used for identification but i'll make you enter it anyway")
	private String username;

	@JsonIgnore
	@Min(value = 8, message = "UwU your passwowd is 2 showt")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}