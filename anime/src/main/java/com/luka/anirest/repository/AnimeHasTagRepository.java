package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Anime_has_Tag;

public interface AnimeHasTagRepository extends JpaRepository<Anime_has_Tag, Integer> {

}
