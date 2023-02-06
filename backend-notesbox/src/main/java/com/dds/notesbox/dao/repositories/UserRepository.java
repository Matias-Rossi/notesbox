package com.dds.notesbox.dao.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.users.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
//TODO: Replace by interface and move special functions to a dedicated service
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

  public boolean isEmailInUse(String email) {
    String query = "FROM User WHERE email = :email";
    List<User> users = em.createQuery(query, User.class).setParameter("email", email).getResultList();
    return !users.isEmpty();
  }

  public User getUserByCredentials(User user) {
    String query = "FROM User WHERE email = :email";
    List<User> users = em.createQuery(query, User.class).setParameter("email", user.getEmail()).getResultList();

    if (users.isEmpty()) {
      System.out.println("User not found");
      return null;
    }
    //TODO: Do in service and using Argon2Encoder

    User fetchedUser = users.get(0);
    String hashedPassword = fetchedUser.getHashedPassword();

    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    boolean isPasswordValid = argon2.verify(hashedPassword, user.getHashedPassword().toCharArray());

    return isPasswordValid ? fetchedUser : null;
  }

  public Optional<User> getOneUserByEmail(String email) {
    String query = "FROM User WHERE email = :email";
    try {
      User user = em.createQuery(query, User.class).setParameter("email", email).getSingleResult();
      return Optional.of(user);
    } catch (NoResultException e) {
      System.out.println("No user with email " + email + " was found" );
    } catch (NonUniqueResultException e) {
      System.out.println("More than one users with email " + email + " were found" );
    }
    return Optional.empty();

  }
}
