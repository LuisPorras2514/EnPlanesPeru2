package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Country;
import com.example.repository.CountryRepository;

@Service
public class CountryService {
	private CountryRepository countryRepository;
	
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public List<Country> getAllCountry() {
		return countryRepository.findAll();
	}
	
}
