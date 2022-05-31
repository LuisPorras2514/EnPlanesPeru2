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
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "seat_quantity", nullable = false)
	private int seatsQuantity;

	@Column(name = "price_car", nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private ServiceTravel serviceTravel;

	@ManyToOne
	@JoinColumn(name = "brand_car_id", nullable = false)
	private BrandCar brandCar;

	@ManyToOne
	@JoinColumn(name = "model_car_id", nullable = false)
	private ModelCar modelCar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatsQuantity() {
		return seatsQuantity;
	}

	public void setSeatsQuantity(int seatsQuantity) {
		this.seatsQuantity = seatsQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ServiceTravel getServiceTravel() {
		return serviceTravel;
	}

	public void setServiceTravel(ServiceTravel serviceTravel) {
		this.serviceTravel = serviceTravel;
	}

	public BrandCar getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(BrandCar brandCar) {
		this.brandCar = brandCar;
	}

	public ModelCar getModelCar() {
		return modelCar;
	}

	public void setModelCar(ModelCar modelCar) {
		this.modelCar = modelCar;
	}

}
