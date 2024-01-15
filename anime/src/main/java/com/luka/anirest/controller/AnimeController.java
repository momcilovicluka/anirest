package com.luka.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luka.model.Anime;
import com.luka.service.AnimeService;

@RestController
@RequestMapping("/anime")
public class AnimeController {

	@Autowired
	AnimeService animeService;

	@GetMapping("/{name}")
	public Anime returnAnime(@PathVariable String name) throws IOException, InterruptedException {
		return animeService.returnAnime(name);
	}

	@PostMapping("/addAnime")
	public Anime addAnime(@RequestBody Anime anime) {
		return animeService.addAnime(anime.getTitle());
	}
}