package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Category;
import com.dds.notesbox.models.products.Product;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Override
    public Category createCategory(String name) {
        return new Category(name);
    }

    @Override
    public void addProductToCategory(Category category, Product product) {
        category.addProduct(product);
    }

    @Override
    public boolean removeProductFromCategory(Category category, Product product) {
        boolean wasElementPresent = category.removeProduct(product);
        return wasElementPresent;
    }
}
