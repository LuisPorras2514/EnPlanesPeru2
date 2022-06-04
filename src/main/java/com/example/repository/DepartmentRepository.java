package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	@Query("FROM Department WHERE country_id = ?1")
	List<Department> findAllByCountry(Long id);
}
