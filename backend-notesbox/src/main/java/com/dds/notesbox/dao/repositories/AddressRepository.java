package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.users.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class AddressRepository implements Dao<Address>{
  @PersistenceContext
  private EntityManager em;

  public List<Address> findAll() {
    String query = "FROM Address";
    List<Address> result = em.createQuery(query, Address.class).getResultList();
    return result;
  }

  public Address findOne(final Long id) {
    return em.find(Address.class, id);
  }

  public void persist(Address entity) {
    em.persist(entity);
  }
 
  public Address update(Address entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    Address address = em.find(Address.class, id);
    em.remove(address);
  }
}
