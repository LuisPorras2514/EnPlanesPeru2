package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Menu;
import com.example.repository.MenuRepository;

@Service
public class MenuService {
	private MenuRepository menuRepository;

	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public List<Menu> getAllMenu() {
		return menuRepository.findAll();
	}

	public List<Menu> getAllMenuByServices(Long id) {
		return menuRepository.findAllByService(id);
	}

	public List<Menu> getAllMenuByType(Long id) {
		return menuRepository.findAllByType(id);
	}

	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu getMenuById(Long id) {
		return menuRepository.findById(id).get();
	}

	public Menu updateMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	public void deleteMenu(Long id) {
		menuRepository.deleteById(id);
	}

}
