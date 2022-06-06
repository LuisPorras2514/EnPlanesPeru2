package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Room;
import com.example.repository.RoomRepository;

@Service
public class RoomService {
	private RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public List<Room> getAllRoom() {
		return roomRepository.findAll();
	}

	public List<Room> getAllRoomByServices(Long id) {
		return roomRepository.findAllByService(id);
	}
	
	public List<Room> getAllRoomByQuantityBed(int id) {
		return roomRepository.findAllByQuantityBed(id);
	}
	
	public List<Room> getAllRoomByQuantityPerson(int id) {
		return roomRepository.findAllByQuantityPerson(id);
	}

	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}

	public Room getRoomById(Long id) {
		return roomRepository.findById(id).get();
	}

	public Room updateRoom(Room room) {
		return roomRepository.save(room);
	}

	public void deleteRoom(Long id) {
		roomRepository.deleteById(id);
	}

}
