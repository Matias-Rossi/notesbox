package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.products.SpecialCollection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Repository
@Transactional
public class SpecialCollectionRepository implements Dao<SpecialCollection>{
  
  @PersistenceContext
  private EntityManager em;

  public List<SpecialCollection> findAll() {
    String query = "FROM SpecialCollection";
    List<SpecialCollection> result = em.createQuery(query, SpecialCollection.class).getResultList();
    return result;
  }

  public SpecialCollection findOne(final Long id) {
    return em.find(SpecialCollection.class, id);
  }

  public void persist(SpecialCollection entity) {
    em.persist(entity);
  }
 
  public SpecialCollection update(SpecialCollection entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    SpecialCollection specialCollection = em.find(SpecialCollection.class, id);
    em.remove(specialCollection);
  }

}
