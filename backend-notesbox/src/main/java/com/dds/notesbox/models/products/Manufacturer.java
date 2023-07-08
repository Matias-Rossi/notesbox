package com.dds.notesbox.models.products;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.orders.ManufacturerPart;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manufacturers")
public class Manufacturer extends PersistentEntity{
  @Column
  @Getter @Setter
  String name;

  @Column
  @Getter @Setter
  String phoneNumber;

  @Column
  @OneToMany(mappedBy = "manufacturer")
  List<ManufacturerPart> assignedOrders = new ArrayList<ManufacturerPart>();


  public Manufacturer(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public void addPartToManufacture(ManufacturerPart manufacturerPart) {
    assignedOrders.add(manufacturerPart);
  }

  public Manufacturer(){}
}
