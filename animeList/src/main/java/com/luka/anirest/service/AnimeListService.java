package com.luka.anirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luka.anirest.dto.ListAnime;
import com.luka.anirest.exception.AnimeAlreadyOnListException;
import com.luka.anirest.exception.AnimeListUnexistentException;
import com.luka.anirest.exception.AnimeUnexistentException;
import com.luka.anirest.model.Anime;
import com.luka.anirest.model.AnimeList;
import com.luka.anirest.model.SimplePrincipal;
import com.luka.anirest.model.User;
import com.luka.anirest.proxy.AnimeProxy;
import com.luka.anirest.proxy.UserProxy;
import com.luka.anirest.repository.AnimeListRepository;
import com.luka.anirest.repository.AnimeRepository;

@Service
public class AnimeListService {
	@Autowired
	AnimeListRepository animeListRepository;
	
	@Autowired
	AnimeRepository animeRepository;
	
	@Autowired
	UserProxy userProxy;
	
	@Autowired
	AnimeProxy animeProxy;

	private static ObjectMapper mapper = new ObjectMapper();

	private SimplePrincipal convertStringToPrincipal(String principalString) {
		SimplePrincipal principal = null;
		JsonNode node = null;
		try {
			node = mapper.readTree(principalString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		principal = mapper.convertValue(node, SimplePrincipal.class);

		return principal;
	}
	
	public AnimeList create(AnimeList animeList, String principalString) {
		SimplePrincipal principal = convertStringToPrincipal(principalString);
		User user = userProxy.returnById(principal.getId());
		animeList.setUser(user);
		return animeListRepository.save(animeList);
	}

	public AnimeList add(ListAnime listAnime, String principalString) {
		SimplePrincipal principal = convertStringToPrincipal(principalString);
		
		AnimeList animeList = null;
		try {			
			animeList = animeListRepository.findById(listAnime.getListId()).get();
		} catch (Exception e) {
			throw new AnimeListUnexistentException("AnimeList with id " + listAnime.getListId() + " does not exist");
		}
		
		if(animeList.getUser().getIdUser() != principal.getId())
			throw new RuntimeException("You can add only for yourself " + principal.getUsername());
		
		Anime anime = null;
		try {
			anime = animeProxy.returnAnime(listAnime.getAnimeId());
		} catch (Exception e) {
			throw new AnimeUnexistentException(anime, "Anime with id " + listAnime.getAnimeId() + " does not exist");
		}
		
		for (Anime anime1 : animeList.getAnimes())
			if(anime1.getIdAnime() == anime.getIdAnime())
				throw new AnimeAlreadyOnListException(anime, "Anime " + anime.getTitle() + " is already on the " + animeList.getTitle() + " list");
		
		animeList.addAnime(anime);
		anime.addAnimeList(animeList);

		animeRepository.save(anime);
		
		return animeListRepository.save(animeList);
	}

	public List<AnimeList> returnLists(String principalString) {
		SimplePrincipal principal = convertStringToPrincipal(principalString);
		return animeListRepository.findByUserId(principal.getId());
	}
}