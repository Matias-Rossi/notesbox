package com.dds.notesbox.models.users;

import java.util.List;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.orders.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Table(name = "addresses")
public class Address extends PersistentEntity{

  @OneToOne(mappedBy = "shippingAddress") @Setter
  Customer customer;

  @OneToMany(mappedBy = "shippingAddress")
  List<Order> orders;

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


  public Address(){}
  
}
