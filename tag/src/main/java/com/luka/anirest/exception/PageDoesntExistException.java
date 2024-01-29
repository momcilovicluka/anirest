package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class PageDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = -3522301340481058238L;

	private final int page;
	private final String Message;
}