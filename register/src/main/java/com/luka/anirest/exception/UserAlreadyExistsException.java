package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luka.anirest.model.User;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 6644175100268508938L;

	private final User user, repoUser;

	public UserAlreadyExistsException(User user, User repoUser, String message) {
		super(message);
		this.user = user;
		this.repoUser = repoUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public User getRepoUser() {
		return repoUser;
	}

}
