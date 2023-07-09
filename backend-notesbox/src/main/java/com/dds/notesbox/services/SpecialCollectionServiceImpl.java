package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.products.ProductSpecialCollection;
import com.dds.notesbox.models.products.ProductSpecialCollectionKey;
import com.dds.notesbox.models.products.SpecialCollection;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialCollectionServiceImpl implements SpecialCollectionService {
    @Override
    public SpecialCollection createSpecialCollection(String name) {
        return new SpecialCollection(name);
    }

    @Override
    public void addProductToSpecialCollection(SpecialCollection specialCollection, Product product) {
        specialCollection.addProduct(product);
    }

    @Override
    public void removeProductFromSpecialCollection(SpecialCollection specialCollection, Product product) {
        Optional<ProductSpecialCollection> psck = specialCollection.getProducts().stream()
                .filter(_psck -> _psck.getProduct().equals(product)).findFirst();
        specialCollection.removeProduct(psck.get());
    }
}
