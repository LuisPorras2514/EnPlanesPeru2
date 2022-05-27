package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "services/services";
	}

	@GetMapping("/services/insert")
	public String createServiceForm(Model model) {
		ServiceTravel serviceTravel = new ServiceTravel();
		serviceTypes = serviceTypeService.getAllServiceTypes();

		model.addAttribute("serviceTravel", serviceTravel);
		model.addAttribute("serviceTypes", serviceTypes);

		return "services/insert-service";
	}

	@PostMapping("/services")
	public String saveStudent(@ModelAttribute("serviceTravel") ServiceTravel serviceTravel) {
		serviceTravel.setStar(0);
		serviceTravelService.saveServiceTravel(serviceTravel);
		return "redirect:/";
	}

	@GetMapping("/services/edit/{id}")
	public String editServicesTravelForm(@PathVariable Long id, Model model) {
		ServiceTravel serviceTravel = serviceTravelService.getServiceTravelById(id);

		model.addAttribute("serviceTravel", serviceTravel);
		model.addAttribute("serviceTypes", serviceTypes);

		return "services/edit-service";
	}

	@PostMapping("/services/{id}")
	public String updateServicesTravel(@PathVariable Long id, @ModelAttribute("serviceTravel") ServiceTravel serviceTravel,
			Model model) {

		ServiceTravel existentServiceTravel = serviceTravelService.getServiceTravelById(id);

		existentServiceTravel.setId(id);
		existentServiceTravel.setName(serviceTravel.getName());
		existentServiceTravel.setDeparment(serviceTravel.getDeparment());
		existentServiceTravel.setProvince(serviceTravel.getProvince());
		existentServiceTravel.setAddress(serviceTravel.getAddress());
		existentServiceTravel.setStar(serviceTravel.getStar());

		serviceTravelService.updateServiceTravel(existentServiceTravel);

		return "redirect:/";
	}

	@GetMapping("/services/{id}")
	public String deleteServiceTravel(@PathVariable Long id) {
		serviceTravelService.deleteServiceTravel(id);
		return "redirect:/";
	}

}
