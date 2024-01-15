package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

	Genre findByName(String genreString);

}
