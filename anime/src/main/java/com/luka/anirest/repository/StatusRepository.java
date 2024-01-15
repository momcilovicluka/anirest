package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	Status findByName(String statusString);

}
