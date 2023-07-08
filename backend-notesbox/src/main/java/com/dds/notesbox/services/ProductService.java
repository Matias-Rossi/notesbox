package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Product;

public interface ProductService{

    public void setDiscountPrice(Long productId, double price);

    public void removeDiscountPrice(Long productId);

    public boolean hasDiscountPrice(Long productId);
}
