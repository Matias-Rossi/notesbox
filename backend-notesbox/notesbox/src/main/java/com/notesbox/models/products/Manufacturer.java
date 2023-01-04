package com.notesbox.models.products;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.notesbox.models.PersistentEntity;
import com.notesbox.models.orders.ManufacturerPart;
import com.notesbox.models.orders.Order;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manufacturers")
public class Manufacturer extends PersistentEntity{
  @Column
  String name;

  @Column
  String phoneNumber;

  @Column
  @OneToMany(mappedBy = "manufacturer_id")
  List<ManufacturerPart> assignedOrders = new ArrayList<ManufacturerPart>();


  public Manufacturer(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public void addPartToManufacture(ManufacturerPart manufacturerPart) {
    assignedOrders.add(manufacturerPart);
  }

  
}
