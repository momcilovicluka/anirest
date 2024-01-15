package com.luka.anirest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ValidationErrorEntity vee = new ValidationErrorEntity("Error count: " + ex.getErrorCount() + ". First error: " + ex.getFieldErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(vee, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BadAnilistRequestException.class)
	public ResponseEntity<AnilistErrorDetails> handleBadAnilistRequestException(BadAnilistRequestException ex,
			WebRequest request) {
		AnilistErrorDetails ed = new AnilistErrorDetails(ex.getMessage(), ex.getResponseBody());
		return new ResponseEntity<AnilistErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
}