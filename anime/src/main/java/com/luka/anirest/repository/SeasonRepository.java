package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {

	Season findByName(String seasonString);

}
