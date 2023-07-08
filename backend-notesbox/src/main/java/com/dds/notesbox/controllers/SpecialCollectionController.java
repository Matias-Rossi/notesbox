package com.dds.notesbox.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.SpecialCollectionRepository;
import com.dds.notesbox.models.products.SpecialCollection;
import com.dds.notesbox.models.products.json.SpecialCollectionJSON;

@RestController
public class SpecialCollectionController {
  @Autowired
  SpecialCollectionRepository specialCollectionRepository;

  @RequestMapping(value = "api/products/special-collections")
  public List<SpecialCollectionJSON> getSpecialCollections() {
    List<SpecialCollection> specialCollections = specialCollectionRepository.findAll();
    return specialCollections.stream().map(sc -> new SpecialCollectionJSON(sc)).collect(Collectors.toList());
  }

  @RequestMapping(value = "api/products/special-collections/{id}")
  public SpecialCollectionJSON getSpecialCollection(@PathVariable Long id) {
    SpecialCollection sc = specialCollectionRepository.findOne(id);
    return new SpecialCollectionJSON(sc);
  }

  //TODO: Hacer el de key especifico
}
