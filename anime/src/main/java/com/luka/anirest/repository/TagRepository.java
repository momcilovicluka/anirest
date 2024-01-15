package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

	Tag findByName(String tagString);

}
