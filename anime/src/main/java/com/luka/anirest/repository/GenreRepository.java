package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

	Genre findByName(String genreString);

}
