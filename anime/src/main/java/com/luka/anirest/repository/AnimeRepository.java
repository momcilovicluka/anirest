package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

	Anime findByTitle(String name);

}