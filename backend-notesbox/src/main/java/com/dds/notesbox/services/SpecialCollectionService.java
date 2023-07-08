package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Product;
import com.dds.notesbox.models.products.SpecialCollection;
import org.springframework.stereotype.Service;

public interface SpecialCollectionService {
    public SpecialCollection createSpecialCollection(String name);

    public void addProductToSpecialCollection(SpecialCollection specialCollection, Product product);

    public void removeProductFromSpecialCollection(SpecialCollection specialCollection, Product product);
}
