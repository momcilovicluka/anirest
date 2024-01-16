package com.luka.anirest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luka.anirest.exception.AnimeAlreadyExistsException;
import com.luka.anirest.exception.BadAnilistRequestException;
import com.luka.anirest.model.Anime;
import com.luka.anirest.service.AnimeService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/anime")
public class AnimeController {

	@Autowired
	AnimeService animeService;

	@GetMapping("/{name}")
	public Anime returnAnime(@PathVariable String name)
			throws IOException, InterruptedException, BadAnilistRequestException {
		return animeService.returnAnime(name);
	}

	@PostMapping("/addAnime")
	public Anime addAnime(@RequestBody @Valid Anime anime)
			throws BadAnilistRequestException, AnimeAlreadyExistsException {
		return animeService.addAnime(anime.getTitle());
	}
}