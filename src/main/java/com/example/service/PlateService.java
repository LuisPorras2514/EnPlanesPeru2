package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Plate;
import com.example.repository.PlateRepository;

@Service
public class PlateService {
	private PlateRepository plateRepository;
	
	public PlateService(PlateRepository plateRepository) {
		this.plateRepository = plateRepository;
	}
	
	public List<Plate> getAllPlates() {
		return plateRepository.findAll();
	}
	
	public List<Plate> getAllPlatesByMenu(Long id) {
		return plateRepository.findAllByMenu(id);
	}
	
	public Plate savePlate(Plate plate) {
		return plateRepository.save(plate);
	}
	
	public Plate getPlateById(Long id) {
		return plateRepository.findById(id).get();
	}
	
	public Plate updatePlate(Plate plate) {
		return plateRepository.save(plate);
	}
	
	public void deletePlate(Long id) {
		plateRepository.deleteById(id);
	}
	
}
