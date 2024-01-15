package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

	Anime findByTitle(String name);

}