package com.luka.anirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.anirest.model.Format;

public interface FormatRepository extends JpaRepository<Format, Integer> {

	Format findByName(String formatString);

}
