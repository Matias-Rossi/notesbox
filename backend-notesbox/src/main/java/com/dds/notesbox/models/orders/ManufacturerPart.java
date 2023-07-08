package com.dds.notesbox.models.orders;

import java.time.LocalDate;

import com.dds.notesbox.models.PersistentEntity;
import com.dds.notesbox.models.products.Manufacturer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manufacturer_by_order")
public class ManufacturerPart extends PersistentEntity {
  
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
  @Getter  @Setter
  private Manufacturer manufacturer;

  public ManufacturerPart(Order order, String partOrdered, LocalDate dateCreated) {
    this.order = order;
    this.partOrdered = partOrdered;
    this.dateCreated = dateCreated;
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

  public ManufacturerPart(){}
}
