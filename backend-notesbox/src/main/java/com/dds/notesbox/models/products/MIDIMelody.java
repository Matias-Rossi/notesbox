package com.dds.notesbox.models.products;

import jakarta.persistence.Embeddable;

@Embeddable
public class MIDIMelody {
  String midiFileName;
  
  String buildSpecsFileName;

  public MIDIMelody(String midiFileName) {
    this.midiFileName = midiFileName;
    generateBuildSpecs();
  }

  private static String generateBuildSpecs() {
    //TODO Custom script imlementation
    return "";
  }

  public MIDIMelody(){}
}
