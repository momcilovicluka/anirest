package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadAnilistRequestException extends Exception {

	private static final long serialVersionUID = 2343435781960390139L;
	private final String responseBody;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public BadAnilistRequestException(String responseBody, String message) {
		super(message);
		this.responseBody = responseBody;
	}

}