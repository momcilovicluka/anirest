package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luka.anirest.model.Anime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)
public class AnimeAlreadyOnListException extends RuntimeException{
	private static final long serialVersionUID = -840469043421789905L;
	private final Anime object;
	private final String message;
}