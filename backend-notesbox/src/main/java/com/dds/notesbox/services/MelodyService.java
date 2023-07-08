package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Melody;
import com.dds.notesbox.models.products.Product;

import java.util.List;

public interface MelodyService{
    //TODO: add MIDI and indications support

    public void setDiscountPrice(Melody melody, double price);

    public void removeDiscountPrice(Melody melody);

    public boolean hasDiscountPrice(Melody melody);

    public double changeFullPrice(Melody melody, double newPrice);

    public List<Melody> fetchAllMelodies();
}
