package com.notesbox.models.products;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Entity
@DiscriminatorValue(value = "Melody")
public class Melody extends Product{
  
  @Getter
  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "category_id")
  private Category category;

  public Melody(String name, String description, double price, double discountPrice, Category category) {
    super(name, description, price, discountPrice);
    this.category = category;
    //TODO Implement other fields
  }

  public Melody(String name, String description, double price, Category category) {
    super(name, description, price);
    this.category = category;
    //TODO Implement other fields
  }

  @Embedded
  MIDIMelody midi;

}
