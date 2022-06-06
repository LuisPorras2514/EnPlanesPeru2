package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.DepartmentService;
import com.example.service.ProvinceService;
import com.google.gson.Gson;

@Controller
@RequestMapping("location" )
public class LocationController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProvinceService provinceService;
	
	@ResponseBody
	@GetMapping("loadDeparmentByCountry/{id}")
	public String loadStatesByCountry(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(departmentService.getAllDeparmentByCountry(id));
	}
	
	@ResponseBody
	@GetMapping("loadProvinceByDeparment/{id}")
	public String loadCitiesByState(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(provinceService.getAllProvinceByDeparment(id));
	}
	
}
