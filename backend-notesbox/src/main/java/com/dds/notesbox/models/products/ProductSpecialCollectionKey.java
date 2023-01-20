package com.dds.notesbox.models.products;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ProductSpecialCollectionKey {
  @Column(name = "product_id") @Getter @Setter
  Long productId;

  @Column(name = "special_collection_id") @Getter @Setter
  Long specialCollectionId;

  public ProductSpecialCollectionKey(Product product, SpecialCollection specialCollection){
    this.productId = product.getId();
    this.specialCollectionId = specialCollection.getId();
  }

  public ProductSpecialCollectionKey(){}
}
