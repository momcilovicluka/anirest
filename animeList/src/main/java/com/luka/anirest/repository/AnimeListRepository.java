package com.luka.anirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luka.anirest.model.AnimeList;

public interface AnimeListRepository extends JpaRepository<AnimeList, Integer> {

	@Query("SELECT a FROM AnimeList a WHERE a.user.id = ?1")
	List<AnimeList> findByUserId(Integer userId);
}