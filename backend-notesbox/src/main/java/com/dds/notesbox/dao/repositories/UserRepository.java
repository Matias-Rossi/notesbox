package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.users.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class UserRepository implements Dao<User>{
  @PersistenceContext
  private EntityManager em;


  public List<User> findAll() {
    String query = "FROM User";
    List<User> result = em.createQuery(query, User.class).getResultList();
    return result;
  }

  public User findOne(final Long id) {
    return em.find(User.class, id);
  }

  public void persist(User entity) {
    em.persist(entity);
  }
 
  public User update(User entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    User user = em.find(User.class, id);
    em.remove(user);
  }

  public User getUserByCredentials(User user) {
    String query = "FROM User WHERE email = :email";
    List<User> users = em.createQuery(query, User.class).setParameter("email", user.getEmail()).getResultList();

    if (users.isEmpty()) {
      System.out.println("User not found");
      return null;
    }

    User fetchedUser = users.get(0);
    String hashedPassword = fetchedUser.getHashedPassword();

    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    boolean isPasswordValid = argon2.verify(hashedPassword, user.getHashedPassword().toCharArray());

    return isPasswordValid ? fetchedUser : null;


  }
}
