package com.dds.notesbox.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.MelodyRepository;
import com.dds.notesbox.models.products.Melody;
import com.dds.notesbox.models.products.json.MelodyJSON;

@RestController
public class MelodyController {

  @Autowired
  private MelodyRepository melodyRepository;

  @GetMapping(value = "api/products/melodies")
  public List<MelodyJSON> getMelodies() {
    List<Melody> melodies = melodyRepository.findAll();
    return melodies.stream().map(m -> new MelodyJSON(m)).collect(Collectors.toList());
  }


  
}
