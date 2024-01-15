package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {

	Type findByName(String typeString);

}
