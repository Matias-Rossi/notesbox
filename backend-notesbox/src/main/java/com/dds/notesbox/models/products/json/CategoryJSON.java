package com.dds.notesbox.models.products.json;

import com.dds.notesbox.models.products.Category;
import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.products.ProductSpecialCollection;
import com.dds.notesbox.models.products.SpecialCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

public class CategoryJSON {

  @Getter
  private Long id;

  @Getter
  private String name;

  @Getter
  private List<MelodyJSON> products = new ArrayList<MelodyJSON>();

  public CategoryJSON(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.products =
      category
        .getProducts()
        .stream()
        .map(p -> new MelodyJSON(p))
        .collect(Collectors.toList());
  }
}
