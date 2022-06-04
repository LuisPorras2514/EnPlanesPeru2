package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.BrandCar;
import com.example.entities.Car;
import com.example.entities.Menu;
import com.example.entities.MenuType;
import com.example.entities.ModelCar;
import com.example.entities.ServiceTravel;
import com.example.service.BrandCarService;
import com.example.service.CarService;
import com.example.service.ModelCarService;
import com.example.service.ServiceTravelService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cars")
public class CarController {
	private ServiceTravelService serviceTravelService;
	private CarService carService;
	private BrandCarService brandCarService;
	private ModelCarService modelCarService;
	
	private List<BrandCar> brandCars = new ArrayList<>();
	private List<ModelCar> modelCars = new ArrayList<>();
	private ServiceTravel serviceTravel = new ServiceTravel();
	
	public CarController(ServiceTravelService serviceTravelService,CarService carService, 
	BrandCarService brandCarService, ModelCarService modelCarService)  {
		this.serviceTravelService = serviceTravelService;
		this.carService = carService;
		this.brandCarService = brandCarService;
		this.modelCarService = modelCarService;
	}
	
	@GetMapping("/list/{id}")
	public String listCars(@PathVariable Long id, Model model) {
		serviceTravel = serviceTravelService.getServiceTravelById(id);
		model.addAttribute("serviceTravel",serviceTravelService.getServiceTravelById(id));
		model.addAttribute("cars", carService.getAllCarByService(id));
		return "cars/cars";
	}
	
	@GetMapping("/insert")
	public String createCarForm(Model model) {
		Car car = new Car();
		brandCars = brandCarService.getAllBrand();
		modelCars = modelCarService.getAllModelCar();
		model.addAttribute("car", car);
		model.addAttribute("brandCars", brandCars);
		model.addAttribute("modelCars", modelCars);
		return "cars/insert-car";
	}
	
	@PostMapping("/save")
	public String saveCar(@ModelAttribute("car") Car car) {
		car.setServiceTravel(serviceTravel);
		carService.saveCar(car);
		String s = "redirect:/cars/list/" + serviceTravel.getId().toString();
		return s;
	}
	
	@GetMapping("/edit/{id}")
	public String editCarForm(@PathVariable Long id, Model model) {
		Car car = carService.getCarById(id);
		brandCars = brandCarService.getAllBrand();
		modelCars = modelCarService.getAllModelCar();
		model.addAttribute("car", car);
		model.addAttribute("brandCars", brandCars);
		model.addAttribute("modelCars", modelCars);
		return "cars/edit-car";
	}

	@PostMapping("/cars-edit/{id}")
	public String updateCar(@PathVariable Long id, @ModelAttribute("car") Car car, Model model) {
		car.setServiceTravel(serviceTravel);
		carService.updateCar(car);
		String s = "redirect:/cars/list/" + serviceTravel.getId().toString();
		return s;
	}

	@GetMapping("/cars-delete/{id}")
	public String deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		String s = "redirect:/cars/list/" + serviceTravel.getId().toString();
		return s;
	}
	
	@GetMapping("/back")
	public String back(Model model) {
		String s = "redirect:/cars/list/" + serviceTravel.getId().toString();
		return s;
	}
	
	@ResponseBody
	@GetMapping("/loadModelByBrand/{id}")
	public String loadModelByBrand(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(modelCarService.getAllModelCarByBrand(id));
	}
	
}
