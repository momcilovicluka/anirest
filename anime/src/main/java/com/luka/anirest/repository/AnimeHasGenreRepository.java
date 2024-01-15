package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Anime_has_Genre;

public interface AnimeHasGenreRepository extends JpaRepository<Anime_has_Genre, Integer> {

}
