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

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ValidationErrorEntity vee = new ValidationErrorEntity("Error count: " + ex.getErrorCount() + ". First error: "
				+ ex.getFieldErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(vee, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<UserAlreadyExistsErrorDetails> handleUserAlreadyExistsException(UserAlreadyExistsException ex,
			WebRequest request) {
		UserAlreadyExistsErrorDetails ed = new UserAlreadyExistsErrorDetails(ex.getUser(), ex.getRepoUser(),
				ex.getMessage());
		return new ResponseEntity<UserAlreadyExistsErrorDetails>(ed, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserNotFoundErrorDetails> handleUserNotFoundException(UserNotFoundException ex,
			WebRequest request) {
		UserNotFoundErrorDetails ed = new UserNotFoundErrorDetails(ex.getUser(), ex.getMessage());
		return new ResponseEntity<UserNotFoundErrorDetails>(ed, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(WrongPasswordException.class)
	public ResponseEntity<UserNotFoundErrorDetails> handeWrongPasswordException(WrongPasswordException ex,
			WebRequest request) {
		UserNotFoundErrorDetails ed = new UserNotFoundErrorDetails(ex.getUser(), ex.getMessage());
		return new ResponseEntity<UserNotFoundErrorDetails>(ed, HttpStatus.FORBIDDEN);
	}
}