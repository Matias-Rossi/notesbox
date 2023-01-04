package com.notesbox.database.repositories;

import javax.persistence.EntityManager;

import com.notesbox.database.Repository;
import com.notesbox.models.products.Melody;

public class MelodiesRepository extends Repository<Melody>  {

  public MelodiesRepository(EntityManager em) {
    super(em, Melody.class);
  }
  
}
