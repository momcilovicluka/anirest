package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Anime_has_Tag;

public interface AnimeHasTagRepository extends JpaRepository<Anime_has_Tag, Integer> {

}
