package com.notesbox.server;

import com.notesbox.controllers.MelodiesController;

import spark.Spark;

public class Router {
  public static void init() {
    Spark.staticFileLocation("/public");
    Router.configure();
}
  private static void configure() {

    MelodiesController melodiesController = new MelodiesController(null);
    
    Spark.path("/melodies", ()-> {
      Spark.get("", melodiesController::getMelodies);
    });
  }
}
