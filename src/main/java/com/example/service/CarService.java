package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Car;
import com.example.repository.CarRepository;

@Service
public class CarService {
	private CarRepository carRepository;
	
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}
	
	public List<Car> getAllCarByModel(Long id) {
		return carRepository.findAllByBrand(id);
	}
	
	public List<Car> getAllCarByService(Long id) {
		return carRepository.findAllByService(id);
	}
	
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}
	
	public Car getCarById(Long id) {
		return carRepository.findById(id).get();
	}
	
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}
	
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}
	
	public void deleteAllCarByService(Long id) {
		carRepository.DeleteAllByService(id);
	}
	
}
