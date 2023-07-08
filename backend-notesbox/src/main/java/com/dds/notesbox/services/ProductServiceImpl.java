package com.dds.notesbox.services;

import com.dds.notesbox.dao.repositories.ProductRepository;
import com.dds.notesbox.models.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    public void setDiscountPrice(Long productId, double price) {
        Product product = getProductFromRepository(productId);

        product.setDiscountPrice(price);
        product.setHasDiscountPrice(true);

        saveProductToRepository(product);
    }

    public void removeDiscountPrice(Long productId) {
        Product product = getProductFromRepository(productId);

        product.setHasDiscountPrice(false);

        saveProductToRepository(product);
    }

    public boolean hasDiscountPrice(Long productId) {
        Product product = getProductFromRepository(productId);

        return product.isHasDiscountPrice();
    }

    private Product getProductFromRepository(Long id) {
        return productRepository.findOne(id);
    }
    private void saveProductToRepository(Product product) {
        productRepository.persist(product);
    }
}
