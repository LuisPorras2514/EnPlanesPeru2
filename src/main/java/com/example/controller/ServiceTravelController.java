package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.entities.Menu;
import com.example.entities.ServiceTravel;
import com.example.entities.ServiceType;
import com.example.service.CarService;
import com.example.service.CountryService;
import com.example.service.DepartmentService;
import com.example.service.MenuService;
import com.example.service.PlateService;
import com.example.service.ProvinceService;
import com.example.service.ServiceTravelService;
import com.example.service.ServiceTypeService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/services")
public class ServiceTravelController {

	@Autowired
	private ServiceTravelService serviceTravelService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private PlateService plateService;
	@Autowired
	private CarService carService;
	@Autowired
	private ServiceTypeService serviceTypeService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ProvinceService provinceService;

	private List<ServiceType> serviceTypes = new ArrayList<>();

	@GetMapping("/list")
	public String listServices(Model model) {
		model.addAttribute("services", serviceTravelService.getAllServices());
		return "services/services";
	}

	@GetMapping("/insert")
	public String createServiceForm(Model model) {
		ServiceTravel serviceTravel = new ServiceTravel();
		serviceTypes = serviceTypeService.getAllServiceTypes();
		model.addAttribute("serviceTravel", serviceTravel);
		model.addAttribute("serviceTypes", serviceTypes);
		model.addAttribute("countries", countryService.getAllCountry());
		return "services/insert-service";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("serviceTravel") ServiceTravel serviceTravel,
			@RequestParam("file") MultipartFile file) {
		
		String road="D://Workplace/demo-EnPlanesPeru/src/main/resources/static/imagen/img-services";
		String url = "";
		String namePhoto = "";
		int index = file.getOriginalFilename().indexOf(".");
		url= "." + file.getOriginalFilename().substring(index+1);
		namePhoto = Calendar.getInstance().getTimeInMillis() + url;
		Path roadFinal = Paths.get(road+"//"+namePhoto);
		
		try {
			Files.write(roadFinal,file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		serviceTravel.setPhoto(namePhoto);
		serviceTravel.setStar(0);
		serviceTravelService.saveServiceTravel(serviceTravel);
		return "redirect:/services/list";
	}

	@GetMapping("/edit/{id}")
	public String editServicesTravelForm(@PathVariable Long id, Model model) {
		ServiceTravel serviceTravel = serviceTravelService.getServiceTravelById(id);
		model.addAttribute("serviceTravel", serviceTravel);
		model.addAttribute("serviceTypes", serviceTypes);
		model.addAttribute("countries", countryService.getAllCountry());
		model.addAttribute("departments",
				departmentService.getAllDeparmentByCountry(serviceTravel.getCountry().getId()));
		model.addAttribute("provinces",
				provinceService.getAllProvinceByDeparment(serviceTravel.getDepartment().getId()));
		model.addAttribute("serviceTypes", serviceTravel.getServiceType());
		return "services/edit-service";
	}

	@PostMapping("/services-edit/{id}")
	public String updateServicesTravel(@PathVariable Long id,
			@ModelAttribute("serviceTravel") ServiceTravel serviceTravel, Model model,
			@RequestParam("file") MultipartFile file) {
		ServiceTravel existentServiceTravel = serviceTravelService.getServiceTravelById(id);
		existentServiceTravel.setId(id);
		existentServiceTravel.setName(serviceTravel.getName());
		existentServiceTravel.setAddress(serviceTravel.getAddress());
		existentServiceTravel.setStar(serviceTravel.getStar());
		existentServiceTravel.setCountry(serviceTravel.getCountry());
		existentServiceTravel.setDepartment(serviceTravel.getDepartment());
		existentServiceTravel.setProvince(serviceTravel.getProvince());
		existentServiceTravel.setServiceType(serviceTravel.getServiceType());
		
		String road="D://Workplace/demo-EnPlanesPeru/src/main/resources/static/imagen/img-services";
		Path roadFinal = Paths.get(road+"//"+existentServiceTravel.getPhoto());
		
		try {
			if(!file.isEmpty()) {
				Files.write(roadFinal,file.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		serviceTravelService.updateServiceTravel(existentServiceTravel);
		return "redirect:/services/list";
	}

	@GetMapping("/services-delete/{id}")
	public String deleteServiceTravel(@PathVariable Long id) {
		ServiceTravel serviceTravel = serviceTravelService.getServiceTravelById(id);
		if (serviceTravel.getServiceType().getId() == 1) {
		} else if (serviceTravel.getServiceType().getId() == 2) {
			List<Menu> menus = new ArrayList<>();
			menus = menuService.getAllMenuByServices(id);
			for (Menu menu : menus) {
				plateService.deleteAllPlateByMenu(menu.getId());
			}
			menuService.deleteAllMenuByService(id);
		} else if (serviceTravel.getServiceType().getId() == 3) {
			carService.deleteAllCarByService(id);
		}
		serviceTravelService.deleteServiceTravel(id);
		return "redirect:/services/list";
	}

	@ResponseBody
	@RequestMapping(value = "loadDeparmentByCountry/{id}", method = RequestMethod.GET)
	public String loadStatesByCountry(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(departmentService.getAllDeparmentByCountry(id));
	}

	@ResponseBody
	@RequestMapping(value = "loadProvinceByDeparment/{id}", method = RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(provinceService.getAllProvinceByDeparment(id));
	}

}
