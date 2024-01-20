package com.luka.anirest.proxy;

import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.luka.anirest.exception.BadAnilistRequestException;
import com.luka.anirest.model.Anime;

@FeignClient(name = "anime", url = "http://localhost:1337/anime")
public interface AnimeProxy {

	@GetMapping("/byId/{id}")
	public Anime returnAnime(@PathVariable int id)
			throws IOException, InterruptedException, BadAnilistRequestException;
}