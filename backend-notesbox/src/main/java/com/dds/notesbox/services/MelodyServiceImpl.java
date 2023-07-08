package com.dds.notesbox.services;

import com.dds.notesbox.dao.repositories.MelodyRepository;
import com.dds.notesbox.models.products.Melody;
import com.dds.notesbox.models.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MelodyServiceImpl implements MelodyService {

    @Autowired
    private MelodyRepository melodyRepository;

    @Override
    public List<Melody> fetchAllMelodies() {
        return melodyRepository.findAll();
    }

    @Override
    public void setDiscountPrice(Long melodyId, double price) {
        Melody melody = getMelodyFromRepository(melodyId);

        melody.setDiscountPrice(price);
        melody.setHasDiscountPrice(true);

        saveMelodyToRepository(melody);
    }

    @Override
    public void removeDiscountPrice(Long melodyId) {
        Melody melody = getMelodyFromRepository(melodyId);

        melody.setHasDiscountPrice(false);

        saveMelodyToRepository(melody);
    }

    @Override
    public boolean hasDiscountPrice(Long melodyId) {
        Melody melody = getMelodyFromRepository(melodyId);

        return melody.isHasDiscountPrice();
    }

    private Melody getMelodyFromRepository(Long id) {
        return melodyRepository.findOne(id);
    }
    private void saveMelodyToRepository(Melody melody) {
        melodyRepository.persist(melody);
    }
}
