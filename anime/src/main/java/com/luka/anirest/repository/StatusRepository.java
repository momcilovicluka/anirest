package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	Status findByName(String statusString);

}
