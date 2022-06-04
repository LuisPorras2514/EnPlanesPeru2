package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {
	
}
