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
@Table(name="plates")
public class Plate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="plate_name", nullable = false)
  private String name;
  	
  @Column(name="plate_price", nullable = false)
  private double price;
  
  @ManyToOne
  @JoinColumn(name="menu_id", nullable = false)
  private Menu menu;

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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

}
