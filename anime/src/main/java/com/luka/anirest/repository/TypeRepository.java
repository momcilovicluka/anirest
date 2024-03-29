package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {

	Type findByName(String typeString);

}
