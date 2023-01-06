package com.dds.notesbox.models.products;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;

@Entity
@DiscriminatorValue(value = "Melody")
public class Melody extends Product{
  


  public Melody(String name, String description, double price, double discountPrice, Category category) {
    super(name, description, price, discountPrice, category);
    //TODO Implement other fields
  }

  public Melody(String name, String description, double price, Category category) {
    super(name, description, price, category);
    //TODO Implement other fields
  }

  @Embedded
  MIDIMelody midi;

  public Melody(){
    super();
  }
}
