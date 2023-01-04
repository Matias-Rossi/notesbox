package com.notesbox.models.orders;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.notesbox.models.products.Manufacturer;

@Entity
@Table(name = "manufacturer_by_order")
public class ManufacturerPart {
  
  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn()
  private Order order;

  @Column
  private String partOrdered;

  @Column
  private boolean delivered = false;

  @Column //TODO: Converter
  private LocalDate dateCreated;

  @Column //TODO: Converter
  private LocalDate dateDelivered;

  @Column
  private boolean hasManufacturerAssigned = false;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn
  private Manufacturer manufacturer;

  public ManufacturerPart(Order order, String partOrdered) {
    this.order = order;
    this.partOrdered = partOrdered;
    this.dateCreated = LocalDate.now();
  }

  public ManufacturerPart(Order order, String partOrdered, Manufacturer manufacturer) {
    this.order = order;
    this.partOrdered = partOrdered;
    this.manufacturer = manufacturer;
    this.dateCreated = LocalDate.now();
  }


  /**
   * @param dateDelivered date in which the part was delivered, if null, `LocalDate.now()` will be used. 
   */
  public void markAsDelivered(LocalDate dateDelivered) {
    if (dateDelivered == null) {
      this.dateDelivered = LocalDate.now();
    } else {
      this.dateDelivered = dateDelivered;
    }
  }

  
}
