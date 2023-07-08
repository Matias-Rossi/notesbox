package com.dds.notesbox.services;

import com.dds.notesbox.dao.repositories.MelodyRepository;
import com.dds.notesbox.models.products.Melody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MelodyService extends ProductService{
    public List<Melody> fetchAllMelodies();
}
