package com.notesbox.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.notesbox.database.repositories.MelodiesRepository;
import com.notesbox.models.products.Category;
import com.notesbox.models.products.Melody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Init {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.notesbox");
    EntityManager em = emf.createEntityManager();

    Category sports = new Category("Sports");
    Category festive = new Category("Festive");
    Melody muchachos = new Melody("Muchacos", "Argentinian chant sang during the 2022 Qatar World Cup", 15, sports);
    Melody jingleBells = new Melody("Jingle Bells", "Traditional christmas melody", 25, 20, festive);

    MelodiesRepository melodiesRepository = new MelodiesRepository(em);
    melodiesRepository.add(muchachos);
    melodiesRepository.add(jingleBells);

    em.close();
  }
}
