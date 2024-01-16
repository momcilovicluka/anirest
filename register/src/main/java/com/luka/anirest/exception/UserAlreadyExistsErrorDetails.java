package com.luka.anirest.exception;

import com.luka.anirest.model.PasswordlessUser;

public class UserAlreadyExistsErrorDetails {

	private final String message;
	private final PasswordlessUser user, repoUser;

	public UserAlreadyExistsErrorDetails(PasswordlessUser passwordlessUser, PasswordlessUser passwordlessUser2,
			String message) {
		super();
		this.message = message;
		this.user = passwordlessUser;
		this.repoUser = passwordlessUser2;
	}

	public String getMessage() {
		return message;
	}

	public PasswordlessUser getUser() {
		return user;
	}

	public PasswordlessUser getRepoUser() {
		return repoUser;
	}

}