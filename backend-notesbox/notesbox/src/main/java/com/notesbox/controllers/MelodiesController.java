package com.notesbox.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.notesbox.controllers.jsonModels.MelodyJson;
import com.notesbox.database.repositories.MelodiesRepository;
import com.notesbox.models.products.MIDIMelody;
import com.notesbox.models.products.Melody;

import spark.Request;
import spark.Response;

public class MelodiesController {
  private EntityManager entityManager;

  public MelodiesController(EntityManager em) {
    this.entityManager = em;
  }

  public String getMelodies(Request request, Response response) {
    MelodiesRepository mr = new MelodiesRepository(entityManager);
    Gson gson = new Gson();
    Integer startIndex;
    Integer endIndex;
    List<Melody> melodies;
    try {
      startIndex = Integer.parseInt(request.queryParams("startIndex"));
      endIndex = Integer.parseInt(request.queryParams("endIndex"));
      melodies = mr.getAllSubset(startIndex, endIndex);
    } catch (Exception e) {
      melodies = mr.getAll();
    }

    List<MelodyJson> jsonMelodies = melodies.stream().map(
      m -> new MelodyJson(m)
    ).collect(Collectors.toList());

    return gson.toJson(jsonMelodies);
  }

  public Response save(Request req, Response response) {
    String name = req.queryParams("name");
    String description = req.queryParams("description");
    double price = Double.parseDouble(req.queryParams("price"));
    double discountPrice = Double.parseDouble(req.queryParams("discountPrice"));
    String categoryName = req.queryParams("category");

    File dir = createMIDIFilesDir();

    MIDIMelody midiMelody = new MIDIMelody(name);

    /*
     * TODO Handle MIDI data
     */

    return response;
  }

  private static File createMIDIFilesDir() {
    File dir = new File("MIDIs");
    dir.mkdir();
    return dir;
  }
}
