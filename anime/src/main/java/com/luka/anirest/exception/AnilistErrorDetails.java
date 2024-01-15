package com.luka.anirest.exception;

public class AnilistErrorDetails {

	private String message, responseBody;

	public AnilistErrorDetails(String message, String responseBody) {
		super();
		this.message = message;
		this.responseBody = responseBody;
	}

	public AnilistErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

}