package com.dds.notesbox.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.CategoryRepository;
import com.dds.notesbox.models.products.Category;
import com.dds.notesbox.models.products.json.CategoryJSON;

@RestController
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @GetMapping(value = "api/products/categories")
  public List<CategoryJSON> getCategories() {
    List<Category> categories = categoryRepository.findAll();
    return categories.stream().map(c -> new CategoryJSON(c)).collect(Collectors.toList());
  }

  @GetMapping(value = "api/products/categories/{id}")
  public CategoryJSON getCategoryById(@PathVariable Long id) {
    Category category = categoryRepository.findOne(id);
    return new CategoryJSON(category);
  }


  @GetMapping(value = "api/products/category-names")
  public List<String> getCategoryNames() {
    List<Category> categories = categoryRepository.findAll();
    return categories.stream().map(c -> c.getName()).collect(Collectors.toList());
  }
}
