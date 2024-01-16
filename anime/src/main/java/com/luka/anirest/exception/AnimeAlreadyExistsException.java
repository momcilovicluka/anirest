package com.luka.anirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luka.anirest.model.Anime;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AnimeAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4613896059283758889L;

	private final Anime anime;

	public AnimeAlreadyExistsException(Anime anime, String message) {
		super(message);
		this.anime = anime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Anime getAnime() {
		return anime;
	}

}
