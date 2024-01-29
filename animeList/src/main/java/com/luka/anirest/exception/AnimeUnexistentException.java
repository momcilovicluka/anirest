package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luka.anirest.model.Anime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class AnimeUnexistentException extends RuntimeException{
	private static final long serialVersionUID = 4134459458622574495L;
	private final Anime object;
	private final String message;
}