package com.dds.notesbox.services;

import com.dds.notesbox.dao.repositories.MelodyRepository;
import com.dds.notesbox.models.products.Melody;
import com.dds.notesbox.models.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MelodyServiceImpl implements MelodyService {


    @Override
    public double getActualPrice(Melody melody) {
        return melody.isHasDiscountPrice()? melody.getDiscountPrice() : melody.getPrice();
    }

    public void setDiscountPrice(Melody melody, double price) {
        melody.setDiscountPrice(price);
        melody.setHasDiscountPrice(true);
    }


    public void removeDiscountPrice(Melody melody) {
        melody.setHasDiscountPrice(false);
    }

    public boolean hasDiscountPrice(Melody melody) {
        return melody.isHasDiscountPrice();
    }

    @Override
    public double changeFullPrice(Melody melody, double newPrice) {
        double prevPrice = melody.getPrice();
        melody.setPrice(newPrice);
        return prevPrice;
    }

}
