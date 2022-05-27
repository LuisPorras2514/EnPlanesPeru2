package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.MenuType;
import com.example.repository.MenuTypeRepository;

@Service
public class MenuTypeService {
	private MenuTypeRepository menuTypeRepository;
	
	public MenuTypeService(MenuTypeRepository menuTypeRepository){
		this.menuTypeRepository = menuTypeRepository;
	}
	
	public List<MenuType> getAllMenuTypes(){
		return menuTypeRepository.findAll();
	}
	
}
