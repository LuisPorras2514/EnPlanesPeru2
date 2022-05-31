package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.ModelCar;
import com.example.repository.ModelCarRepository;

@Service
public class ModelCarService {
	private ModelCarRepository modelCarRepository;
	
	public ModelCarService(ModelCarRepository modelCarRepository) {
		this.modelCarRepository = modelCarRepository;
	}
	
	public List<ModelCar> getAllModelCar() {
		return modelCarRepository.findAll();
	}
	
	public List<ModelCar> getAllModelCar(Long id) {
		return modelCarRepository.findAllByBrand(id);
	}
	
}
