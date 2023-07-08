package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Category;
import com.dds.notesbox.models.products.Product;

public interface CategoryService {
    public Category createCategory(String name);

    public void addProductToCategory(Category category, Product product);

    public boolean removeProductFromCategory(Category category, Product product);
}
