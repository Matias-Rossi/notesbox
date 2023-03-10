package com.dds.notesbox.models.products;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import com.dds.notesbox.models.PersistentEntity;

import lombok.Getter;

@Entity
@Table(name = "categories")
public class Category extends PersistentEntity {
  @Column @Getter
  private String name;
  
  @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "category") @Getter
  private List<Product> products = new ArrayList<Product>();


  public Category(String name, List<Product> products) {
    this.name = name;
    this.products = products;
    //unused?
  }

  public Category(String name) {
    this.name = name;
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void removeProduct(Product product) {
    products.remove(product);
  }

  public Category(){}
  
}
