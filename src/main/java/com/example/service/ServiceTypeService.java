package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.ServiceType;
import com.example.repository.ServiceTypeRepository;

@Service
public class ServiceTypeService {
	private ServiceTypeRepository serviceTypeRepository;
	
	public ServiceTypeService(ServiceTypeRepository serviceTypeRepository) {
		this.serviceTypeRepository = serviceTypeRepository;
	}
	
	public List<ServiceType> getAllServiceTypes(){
		return serviceTypeRepository.findAll();
	}
}
