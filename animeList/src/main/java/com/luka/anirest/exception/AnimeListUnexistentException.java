package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class AnimeListUnexistentException extends RuntimeException{
	private static final long serialVersionUID = -830924382676199266L;
	private final String message;
}