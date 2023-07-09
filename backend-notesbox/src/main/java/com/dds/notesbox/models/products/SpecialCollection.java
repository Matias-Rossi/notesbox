package com.dds.notesbox.models.products;

import java.util.ArrayList;
import java.util.List;

import com.dds.notesbox.models.PersistentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "special_collections")
public class SpecialCollection extends PersistentEntity {
  @Column @Getter
  private String name; 

  @Getter
  @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "specialCollection")
  private List<ProductSpecialCollection> products = new ArrayList<ProductSpecialCollection>();

  public SpecialCollection(String name) {
    this.name = name;
  }

  public void addProduct(Product product) {
    ProductSpecialCollection psc = new ProductSpecialCollection(this, product);
    products.add(psc);
  }

  public void removeProduct(ProductSpecialCollection product) {
    products.remove(product);
    product.remove();
    //TODO: Check and fix remove logic
  }
  
  public SpecialCollection() {}
}
