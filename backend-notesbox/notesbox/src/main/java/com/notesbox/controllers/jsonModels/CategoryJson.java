package com.notesbox.controllers.jsonModels;

import com.notesbox.models.products.Category;

public class CategoryJson {
  private long id;
  private String name;

  public CategoryJson(Category category) {
    this.id = category.getId();
    this.name = category.getName();
  }
}
