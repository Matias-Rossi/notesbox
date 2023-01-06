package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.users.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class UserRepository implements Dao<User>{
  @PersistenceContext
  private EntityManager em;


  public List<User> findAll() {
    String query = "SELECT * FROM User";
    List<User> resultado = em.createQuery(query, User.class).getResultList();
    return resultado;
  }

  public User findOne(final Long id) {
    return em.find(User.class, id);
  }

  public User createOrMerge(User entity) {
    return em.merge(entity);
  }
 
  public User update(User entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    User usuario = em.find(User.class, id);
    em.remove(usuario);
  }
}
