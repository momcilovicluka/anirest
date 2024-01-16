package com.luka.anirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}