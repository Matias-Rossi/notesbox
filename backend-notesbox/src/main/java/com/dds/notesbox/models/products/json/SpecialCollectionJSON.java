package com.dds.notesbox.models.products.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dds.notesbox.models.products.ProductSpecialCollection;
import com.dds.notesbox.models.products.SpecialCollection;

import lombok.Getter;

public class SpecialCollectionJSON {
  @Getter
  private Long id;

  @Getter
  private String name;

  @Getter
  private List<MelodyJSON> products = new ArrayList<MelodyJSON>();

  public SpecialCollectionJSON(SpecialCollection sp) {
    this.id = sp.getId();
    this.name = sp.getName();

    Iterator<ProductSpecialCollection> iterator = sp.getProducts().iterator();

    while(iterator.hasNext()) {
      ProductSpecialCollection psc = iterator.next();
      products.add(new MelodyJSON(psc.getProduct()));
    }

  }
}
