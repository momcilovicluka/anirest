package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luka.anirest.model.PasswordlessUser;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class WrongPasswordException extends Exception {

	private static final long serialVersionUID = 7031831168202453090L;

	private final PasswordlessUser user;

	public WrongPasswordException(PasswordlessUser passwordlessUser, String message) {
		super(message);
		this.user = passwordlessUser;
	}

	public PasswordlessUser getUser() {
		return user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}