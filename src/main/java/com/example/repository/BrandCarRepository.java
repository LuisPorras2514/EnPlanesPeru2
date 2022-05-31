package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.BrandCar;

public interface BrandCarRepository extends JpaRepository<BrandCar,Long> {

}
