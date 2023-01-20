package com.dds.notesbox.models.products;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;

@Entity
public class ProductSpecialCollection {
  @EmbeddedId
  ProductSpecialCollectionKey id;

  @Column @Getter
  private boolean disabled = false;

  @ManyToOne @Getter
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne @Getter
  @MapsId("specialCollectionId")
  @JoinColumn(name = "special_collection_id")
  private SpecialCollection specialCollection;

  public ProductSpecialCollection(SpecialCollection specialCollection, Product product) {
    this.id = new ProductSpecialCollectionKey(product, specialCollection);
    this.specialCollection = specialCollection;
    this.product = product;
    product.addSpecialCollection(this);
  }

  public void remove() {
    disabled = true;
  }

  public ProductSpecialCollection() {}
 
}
