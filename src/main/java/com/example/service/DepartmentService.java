package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	public List<Department> getAllDeparment() {
		return departmentRepository.findAll();
	}
	
	public List<Department> getAllDeparmentByCountry(Long id) {
		return departmentRepository.findAllByCountry(id);
	}
}
