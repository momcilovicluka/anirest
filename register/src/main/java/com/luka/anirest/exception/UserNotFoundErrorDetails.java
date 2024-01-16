package com.luka.anirest.exception;

import com.luka.anirest.model.User;

public class UserNotFoundErrorDetails {

	private final String message;
	private final User user;

	public UserNotFoundErrorDetails(User user, String message) {
		super();
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public User getUser() {
		return user;
	}

}