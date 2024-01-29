package com.luka.anirest.exception;

public class ValidationErrorEntity {
	private String message;

	public ValidationErrorEntity(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}