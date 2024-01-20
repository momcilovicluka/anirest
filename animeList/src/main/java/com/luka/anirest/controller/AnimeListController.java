package com.luka.anirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luka.anirest.dto.ListAnime;
import com.luka.anirest.model.AnimeList;
import com.luka.anirest.service.AnimeListService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/anime-list")
public class AnimeListController {
	
	@Autowired
	AnimeListService animeListService;

	@PostMapping("/create")
	public AnimeList create(@Valid @RequestBody AnimeList animeList, @RequestHeader String principal) {
		return animeListService.create(animeList, principal);
	}
	
	@PostMapping("/addToList")
	public AnimeList postMethodName(@Valid @RequestBody ListAnime listAnime, @RequestHeader String principal) {
		return animeListService.add(listAnime, principal);
	}
	
	@GetMapping("/lists")
	public List<AnimeList> returnLists(@RequestHeader String principal) {
		return animeListService.returnLists(principal);
	}
	
}