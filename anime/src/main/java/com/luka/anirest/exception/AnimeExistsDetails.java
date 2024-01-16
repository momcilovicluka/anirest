package com.luka.anirest.exception;

import com.luka.anirest.model.Anime;

public class AnimeExistsDetails {

	private final String message;
	private final Anime anime;

	public AnimeExistsDetails(Anime anime, String message) {
		super();
		this.anime = anime;
		this.message = message;
	}

	public Anime getAnime() {
		return anime;
	}

	public String getMessage() {
		return message;
	}

}