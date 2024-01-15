package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {

	Season findByName(String seasonString);

}
