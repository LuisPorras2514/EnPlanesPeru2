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

import com.example.entities.Menu;
import com.example.entities.MenuType;
import com.example.entities.ServiceTravel;
import com.example.service.MenuService;
import com.example.service.MenuTypeService;
import com.example.service.ServiceTravelService;

@Controller
@RequestMapping("/menus")
public class MenuController {
	private MenuService menuService;
	private MenuTypeService menuTypeService;
	private ServiceTravelService serviceTravelService;

	private List<MenuType> menuTypes = new ArrayList<>();
	private ServiceTravel serviceTravel = new ServiceTravel();

	public MenuController(MenuService menuService, MenuTypeService menuTypeService, ServiceTravelService serviceTravelService) {
		this.menuService = menuService;
		this.menuTypeService = menuTypeService;
		this.serviceTravelService = serviceTravelService;
	}

	@GetMapping("/list/{id}")
	public String home(@PathVariable Long id, Model model) {
		
		serviceTravel = serviceTravelService.getServiceTravelById(id);
		model.addAttribute("serviceTravel",serviceTravelService.getServiceTravelById(id));
		model.addAttribute("menus", menuService.getAllMenuByServices(id));
		
		return "menus/menus";
	}

	@GetMapping("/insert")
	public String createMenuForm(Model model) {
		
		Menu menu = new Menu();
		menuTypes = menuTypeService.getAllMenuTypes();
		
		model.addAttribute("menu", menu);
		model.addAttribute("menuTypes", menuTypes);

		return "menus/insert-menu";
	}
	
	@PostMapping("/save")
	public String saveMenu(@ModelAttribute("menu") Menu menu) {
		
		menu.setServiceTravel(serviceTravel);
		menuService.saveMenu(menu);
		String s = "redirect:/menus/list/" + serviceTravel.getId().toString();
		return s;
	}

	@GetMapping("/edit/{id}")
	public String editMenuForm(@PathVariable Long id, Model model) {
		Menu menu = menuService.getMenuById(id);
		
		model.addAttribute("menu", menu);
		model.addAttribute("menuTypes", menuTypes);

		return "menus/edit-menu";
	}

	@PostMapping("/menus-edit/{id}")
	public String updateMenu(@PathVariable Long id, @ModelAttribute("menu") Menu menu, Model model) {
		Menu existentMenu = menuService.getMenuById(id);

		existentMenu.setId(id);
		existentMenu.setName(menu.getName());
		existentMenu.setMenuType(menu.getMenuType());

		menuService.updateMenu(existentMenu);

		String s = "redirect:/menus/list/" + serviceTravel.getId().toString();
		return s;
	}

	@GetMapping("/menus-delete/{id}")
	public String deleteMenu(@PathVariable Long id) {
		menuService.deleteMenu(id);
		String s = "redirect:/menus/list/" + serviceTravel.getId().toString();
		return s;
	}
	
	@GetMapping("/back")
	public String back(Model model) {
		String s = "redirect:/menus/list/" + serviceTravel.getId().toString();
		return s;
	}

}
