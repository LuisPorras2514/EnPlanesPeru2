package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long> {
	
	@Query("FROM Province WHERE department_id = ?1")
	List<Province> findAllByDepartment(Long id);
}
