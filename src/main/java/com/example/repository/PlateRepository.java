package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Plate;

public interface PlateRepository extends JpaRepository<Plate, Long> {

	@Query("FROM Plate WHERE menu_id = ?1")
	List<Plate> findAllByMenu(Long id);

	@Transactional
	@Modifying
	@Query("DELETE FROM Plate WHERE menu_id = ?1")
	void DeleteAllByMenu(Long id);
}
