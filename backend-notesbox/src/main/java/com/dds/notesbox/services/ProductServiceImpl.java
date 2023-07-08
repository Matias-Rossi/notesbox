package com.dds.notesbox.services;

import com.dds.notesbox.dao.repositories.ProductRepository;
import com.dds.notesbox.models.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public double getActualPrice(Product product) {
        return product.isHasDiscountPrice()? product.getDiscountPrice() : product.getPrice();
    }

    @Override
    public void setDiscountPrice(Product product, double price) {
        product.setDiscountPrice(price);
        product.setHasDiscountPrice(true);
    }

    @Override
    public void removeDiscountPrice(Product product) {
        product.setHasDiscountPrice(false);
    }

    @Override
    public boolean hasDiscountPrice(Product product) {
        return product.isHasDiscountPrice();
    }

    @Override
    public double changeFullPrice(Product product, double newPrice) {
        double previousPrice = product.getPrice();
        product.setPrice(newPrice);
        return previousPrice;
    }

}
