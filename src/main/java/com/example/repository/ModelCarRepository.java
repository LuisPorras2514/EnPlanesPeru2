package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.ModelCar;

public interface ModelCarRepository extends JpaRepository<ModelCar,Long> {
	
	@Query("FROM ModelCar WHERE brand_car_id = ?1")
	List<ModelCar> findAllByBrand(Long id);
	
}
