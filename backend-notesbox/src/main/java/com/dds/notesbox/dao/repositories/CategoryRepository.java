package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.products.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class CategoryRepository implements Dao<Category>{

  @PersistenceContext
  private EntityManager em;

  public List<Category> findAll() {
    String query = "FROM Category";
    List<Category> result = em.createQuery(query, Category.class).getResultList();
    return result;
  }

  public Category findOne(final Long id) {
    return em.find(Category.class, id);
  }

  public void persist(Category entity) {
    em.persist(entity);
  }
 
  public Category update(Category entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    Category category = em.find(Category.class, id);
    em.remove(category);
  }

}
