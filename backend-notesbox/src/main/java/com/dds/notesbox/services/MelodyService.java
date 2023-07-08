package com.dds.notesbox.services;

import com.dds.notesbox.models.products.Melody;

import java.util.List;

public interface MelodyService extends ProductService{
    public List<Melody> fetchAllMelodies();
}
