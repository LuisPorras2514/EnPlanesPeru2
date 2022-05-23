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
@Table(name="menus")
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="menu_name", nullable = false)
  private String name;
  
  @ManyToOne
  @JoinColumn(name="menu_type_id", nullable = false)
  private MenuType menuType;
  
  @ManyToOne
  @JoinColumn(name="service_id", nullable = false)
  private ServiceTravel serviceTravel;

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

  public MenuType getMenuType() {
    return menuType;
  }

  public void setMenuType(MenuType menuType) {
    this.menuType = menuType;
  }

  public ServiceTravel getServiceTravel() {
    return serviceTravel;
  }

  public void setServiceTravel(ServiceTravel serviceTravel) {
    this.serviceTravel = serviceTravel;
  }
  
}
