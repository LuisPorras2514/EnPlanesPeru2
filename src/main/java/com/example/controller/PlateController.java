package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Menu;
import com.example.entities.Plate;
import com.example.service.MenuService;
import com.example.service.PlateService;

@Controller
@RequestMapping("/plates")
public class PlateController {
	private PlateService plateService;
	private MenuService menuService;

	private Menu menu;

	public PlateController(PlateService plateService, MenuService menuService) {
		this.plateService = plateService;
		this.menuService = menuService;
	}

	@GetMapping("/list/{id}")
	public String listPlates(@PathVariable Long id, Model model) {
		menu = menuService.getMenuById(id);
		model.addAttribute("menu", menu);
		model.addAttribute("plates", plateService.getAllPlatesByMenu(menu.getId()));
		return "plates/plates";
	}

	@GetMapping("/insert")
	public String createPlateForm(Model model) {
		Plate plate = new Plate();
		model.addAttribute("plate", plate);
		return "plates/insert-plate";
	}

	@PostMapping("/save")
	public String savePlate(@ModelAttribute("plate") Plate plate) {
		plate.setMenu(menu);
		plateService.savePlate(plate);
		String s = "redirect:/plates/list/" + menu.getId().toString();
		return s;
	}

	@GetMapping("/edit/{id}")
	public String editPlateForm(@PathVariable Long id, Model model) {
		Plate plate = plateService.getPlateById(id);
		model.addAttribute("plate", plate);
		return "plates/edit-plate";
	}

	@PostMapping("/plates-edit/{id}")
	public String updatePlate(@PathVariable Long id, @ModelAttribute("plate") Plate plate, Model model) {
		plate.setMenu(menu);
		plateService.updatePlate(plate);
		String s = "redirect:/plates/list/" + menu.getId().toString();
		return s;
	}

	@GetMapping("/plates-delete/{id}")
	public String deletePlate(@PathVariable Long id) {
		plateService.deletePlate(id);
		String s = "redirect:/plates/list/" + menu.getId().toString();
		return s;
	}

	@GetMapping("/back")
	public String back(Model model) {
		String s = "redirect:/plates/list/" + menu.getId().toString();
		return s;
	}

}
