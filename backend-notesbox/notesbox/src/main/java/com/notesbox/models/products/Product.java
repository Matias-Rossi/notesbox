package com.notesbox.models.products;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.notesbox.models.PersistentEntity;

import lombok.Getter;

@Entity
@Table(name = "products")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product extends PersistentEntity {

  @Getter
  @Column
  private String name;

  @Getter
  @Column
  private String description;

  @Getter
  @Column
  private double price;

  @Getter
  @Column
  private boolean hasDiscountPrice;

  @Getter
  @Column
  private double discountPrice;

  public Product(String name, String description, double price) {
    this.price = price;
    this.hasDiscountPrice = false;
    this.name = name;
    this.description = description;
  }

  public Product(String name, String description, double price, double discountPrice) {
    this.price = price;
    this.hasDiscountPrice = true;
    this.discountPrice = discountPrice;
    this.name = name;
    this.description = description;
  }

  public void addDiscountPrice(double price) {
    this.discountPrice = price;
  }

  public void removeDiscountPrice() {
    this.hasDiscountPrice = false;
  }

  public boolean hasDiscountPrice() {
    return this.hasDiscountPrice;
  }
}
