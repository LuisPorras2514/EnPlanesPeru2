package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long> {
	
	@Query("FROM Menu WHERE service_id = ?1")
	List<Menu> findAllByService(Long id);
	
	@Query("FROM Menu WHERE menu_type_id = ?1")
	List<Menu> findAllByType(Long id);
	
}
