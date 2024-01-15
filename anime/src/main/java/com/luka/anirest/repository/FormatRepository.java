package com.luka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luka.model.Format;

public interface FormatRepository extends JpaRepository<Format, Integer> {

	Format findByName(String formatString);

}
