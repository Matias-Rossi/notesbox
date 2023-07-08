package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Product;

public interface ProductService{
    public double getActualPrice(Product product);

    public void setDiscountPrice(Product product, double price);

    public void removeDiscountPrice(Product product);

    public boolean hasDiscountPrice(Product product);

    public double changeFullPrice(Product product, double newPrice);
}
