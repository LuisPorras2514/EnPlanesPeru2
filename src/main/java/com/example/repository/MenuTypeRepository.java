package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.MenuType;

public interface MenuTypeRepository extends JpaRepository<MenuType,Long> {

}