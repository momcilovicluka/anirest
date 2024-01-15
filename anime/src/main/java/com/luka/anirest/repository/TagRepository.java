package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

	Tag findByName(String tagString);

}
