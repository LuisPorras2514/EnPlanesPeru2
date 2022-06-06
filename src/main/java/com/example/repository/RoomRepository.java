package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{

	@Query("FROM Room WHERE service_id = ?1")
	List<Room> findAllByService(Long id);
	
	@Query("FROM Room WHERE quantityBed > ?1")
	List<Room> findAllByQuantityBed(int id);
	
	@Query("FROM Room WHERE quantityPerson > ?1")
	List<Room> findAllByQuantityPerson(int id);
	
}
