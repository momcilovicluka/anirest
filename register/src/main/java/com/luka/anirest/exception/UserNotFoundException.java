package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luka.anirest.model.PasswordlessUser;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 7883989104931158417L;

	private final PasswordlessUser user;

	public UserNotFoundException(PasswordlessUser user, String message) {
		super(message);
		this.user = user;
	}

	public PasswordlessUser getUser() {
		return user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}