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
@Table(name="services_travel")
public class ServiceTravel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="service_name", nullable = false)
  private String name;
  @Column(name="address", nullable = false)
  private String address;
  @Column(name="star", nullable = false)
  private int star;
  @Column(name="province", nullable = false)
  private String province;
  @Column(name="deparment", nullable = false)
  private String deparment;
  
  @ManyToOne
  @JoinColumn(name="service_type_id", nullable = false)
  private ServiceType serviceType;

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getDeparment() {
    return deparment;
  }

  public void setDeparment(String deparment) {
    this.deparment = deparment;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

}
