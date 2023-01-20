package com.dds.notesbox.models.products;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import com.dds.notesbox.models.PersistentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

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

  //TODO: Add introduction date

  @Getter
  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "category_id")
  private Category category;

  @Getter
  @OneToMany(mappedBy = "product")
  Set<ProductSpecialCollection> specialCollections = new HashSet<ProductSpecialCollection>();

  public Product(String name, String description, double price, Category category) {
    this.price = price;
    this.hasDiscountPrice = false;
    this.name = name;
    this.description = description;
    this.category = category;
    category.addProduct(this);
  }

  public Product(String name, String description, double price, double discountPrice, Category category) {
    this.price = price;
    this.hasDiscountPrice = true;
    this.discountPrice = discountPrice;
    this.name = name;
    this.description = description;
    this.category = category;
    category.addProduct(this);
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

  public void addSpecialCollection(ProductSpecialCollection psc) {
    this.specialCollections.add(psc);
  }

  public void removeSpecialCollection(ProductSpecialCollection psc) {
    this.specialCollections.remove(psc);
  }

  public Product(){}
}
