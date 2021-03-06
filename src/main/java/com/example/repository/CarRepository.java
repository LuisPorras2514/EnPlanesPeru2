package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
	
	@Query("FROM Car WHERE service_id = ?1")
	List<Car> findAllByService(Long id);
	
	@Query("FROM Car WHERE brand_car_id = ?1")
	List<Car> findAllByBrand(Long id);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Car WHERE service_id = ?1")
	void DeleteAllByService(Long id);
	
}
