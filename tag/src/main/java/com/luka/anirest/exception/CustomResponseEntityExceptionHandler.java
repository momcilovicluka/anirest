package com.luka.anirest.exception;

import java.time.Instant;
import java.util.Arrays;

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

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ValidationErrorEntity vee = new ValidationErrorEntity("Error count: " + ex.getErrorCount() + ". First error: "
				+ ex.getFieldErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(vee, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PageDoesntExistException.class)
	public ResponseEntity<ErrorDetails> handleAnimeUnexistentException(PageDoesntExistException ex,
			WebRequest request) {
		ErrorDetails ed = new ErrorDetails(ex.getMessage(), Instant.now(), Arrays.toString(ex.getStackTrace()));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.NOT_ACCEPTABLE);
	}
}