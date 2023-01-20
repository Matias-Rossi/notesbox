package com.dds.notesbox.models.products.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.products.ProductSpecialCollection;

import lombok.Getter;

public class MelodyJSON {
  @Getter
  private Long id;

  @Getter
  private String name;

  @Getter
  private double price;

  @Getter
  private double discountPrice;

  @Getter
  private String categoryName;

  @Getter
  private List<String> specialCollectionNames = new ArrayList<String>();


  public MelodyJSON(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.price = product.getPrice();
    this.discountPrice = product.getDiscountPrice();
    this.categoryName = product.getCategory().getName();

    Iterator<ProductSpecialCollection> iterator = product.getSpecialCollections().iterator();
    while (iterator.hasNext()) {
      this.specialCollectionNames.add(iterator.next().getSpecialCollection().getName());
    }
  }
  
}
