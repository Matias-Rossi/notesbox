package com.notesbox.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
  @Column
  private String street;
  @Column
  private String number;
  @Column
  private String city;
  @Column
  private String province;
  @Column
  private String country;

  @Column(nullable = true)
  private String floor;
  @Column(nullable = true)
  private String apartment;


  public Address(String street, String number, String city, String province, String country, String floor,
      String apartment) {
    this.street = street;
    this.number = number;
    this.city = city;
    this.province = province;
    this.country = country;
    this.floor = floor;
    this.apartment = apartment;
  }

  
}
