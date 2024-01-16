package com.luka.anirest.exception;

import com.luka.anirest.model.PasswordlessUser;

public class UserNotFoundErrorDetails {

	private final String message;
	private final PasswordlessUser user;

	public UserNotFoundErrorDetails(PasswordlessUser passwordlessUser, String message) {
		super();
		this.message = message;
		this.user = passwordlessUser;
	}

	public String getMessage() {
		return message;
	}

	public PasswordlessUser getUser() {
		return user;
	}

}