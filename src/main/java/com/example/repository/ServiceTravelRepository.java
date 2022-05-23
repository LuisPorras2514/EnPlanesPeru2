package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.ServiceTravel;

public interface ServiceTravelRepository extends JpaRepository<ServiceTravel,Long> {
	@Query("FROM ServiceTravel WHERE service_type_id = ?1")
	List<ServiceTravel> findAllByType(Long id);
}
