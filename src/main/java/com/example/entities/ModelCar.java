package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "model_cars")
public class ModelCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "model_name", nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "brand_car_id", nullable = false)
	private BrandCar brandCar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BrandCar getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(BrandCar brandCar) {
		this.brandCar = brandCar;
	}
	
}
