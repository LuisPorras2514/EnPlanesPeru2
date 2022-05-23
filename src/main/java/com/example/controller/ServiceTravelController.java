package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entities.ServiceTravel;
import com.example.entities.ServiceType;
import com.example.service.ServiceTravelService;
import com.example.service.ServiceTypeService;

@Controller
public class ServiceTravelController {
	private ServiceTravelService serviceTravelService;
	private ServiceTypeService serviceTypeService;
	
	private List<ServiceType> serviceTypes = new ArrayList<>();

	public ServiceTravelController(ServiceTravelService serviceTravelService, ServiceTypeService serviceTypeService) {
		this.serviceTravelService = serviceTravelService;
		this.serviceTypeService = serviceTypeService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("services", serviceTravelService.getAllServices());
		return "services";
	}

	@GetMapping("/services/new")
	public String createStudentForm(Model model) {
		ServiceTravel serviceTravel = new ServiceTravel();
		serviceTypes = serviceTypeService.getAllServiceTypes();
		
		model.addAttribute("serviceTravel",serviceTravel);
		model.addAttribute("serviceTypes",serviceTypes);
		
		return "insert-service";
	}
	
	@PostMapping("/services")
	public String saveStudent(@ModelAttribute("serviceTravel") ServiceTravel serviceTravel){
		serviceTravel.setStar(0);
		serviceTravelService.saveServiceTravel(serviceTravel);
		return "redirect:/";
	}
}
