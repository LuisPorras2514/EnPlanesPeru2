package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.ServiceTravel;
import com.example.repository.ServiceTravelRepository;

@Service
public class ServiceTravelService {
	private ServiceTravelRepository serviceTravelRepository;
	
	public ServiceTravelService(ServiceTravelRepository serviceTravelRepository) {
		this.serviceTravelRepository = serviceTravelRepository;
	}
	
	public List<ServiceTravel> getAllServices(){
		return serviceTravelRepository.findAll();
	}
	
	public List<ServiceTravel> getAllServicesByType(Long id){
		return serviceTravelRepository.findAllByType(id);
	}
	
	public ServiceTravel saveServiceTravel(ServiceTravel serviceTravel) {
		return serviceTravelRepository.save(serviceTravel);
	}
	
	public ServiceTravel getServiceTravelById(Long id) {
		return serviceTravelRepository.findById(id).get();
	}
	
	public ServiceTravel updateServiceTravel(ServiceTravel serviceTravel) {
		return serviceTravelRepository.save(serviceTravel);
	}
	
	public void deleteServiceTravel(Long id) {
		serviceTravelRepository.deleteById(id);
	}
}
