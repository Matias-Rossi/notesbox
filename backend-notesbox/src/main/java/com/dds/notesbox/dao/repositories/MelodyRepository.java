package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.products.Melody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class MelodyRepository implements Dao<Melody>{

  @PersistenceContext
  private EntityManager em;

  public List<Melody> findAll() {
    String query = "FROM Melody";
    List<Melody> result = em.createQuery(query, Melody.class).getResultList();
    return result;
  }

  public Melody findOne(final Long id) {
    return em.find(Melody.class, id);
  }

  public void persist(Melody entity) {
    em.persist(entity);
  }
 
  public Melody update(Melody entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    Melody melody = em.find(Melody.class, id);
    em.remove(melody);
  }

}
