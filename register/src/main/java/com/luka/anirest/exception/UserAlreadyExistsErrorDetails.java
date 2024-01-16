package com.luka.anirest.exception;

import com.luka.anirest.model.User;

public class UserAlreadyExistsErrorDetails {

	private final String message;
	private final User user, repoUser;

	public UserAlreadyExistsErrorDetails(User user, User repoUser, String message) {
		super();
		this.message = message;
		this.user = user;
		this.repoUser = repoUser;
	}

	public String getMessage() {
		return message;
	}

	public User getUser() {
		return user;
	}

	public User getRepoUser() {
		return repoUser;
	}

}