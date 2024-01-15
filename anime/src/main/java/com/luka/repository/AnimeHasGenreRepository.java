package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Anime_has_Genre;

public interface AnimeHasGenreRepository extends JpaRepository<Anime_has_Genre, Integer> {

}
