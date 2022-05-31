package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.BrandCar;
import com.example.repository.BrandCarRepository;

@Service
public class BrandCarService {
	private BrandCarRepository brandCarRepository;
	
	public BrandCarService(BrandCarRepository brandCarRepository) {
		this.brandCarRepository = brandCarRepository;
	}
	
	public List<BrandCar> getAllBrand() {
		return brandCarRepository.findAll();
	}
	
}
