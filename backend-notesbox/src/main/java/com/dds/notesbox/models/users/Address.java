package com.dds.notesbox.models.users;

import java.util.List;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.orders.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
public class Address extends PersistentEntity {

  @OneToOne(mappedBy = "shippingAddress", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}) @Setter @Getter
  Customer customer;

  @OneToMany(mappedBy = "shippingAddress") @Setter
  List<Order> orders;

  @Column @Getter
  private String street;
  @Column @Getter
  private String number;
  @Column @Getter
  private String city;
  @Column @Getter
  private String province;
  @Column @Getter
  private String country;

  @Column(nullable = true) @Getter
  private String floor;
  @Column(nullable = true) @Getter
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
