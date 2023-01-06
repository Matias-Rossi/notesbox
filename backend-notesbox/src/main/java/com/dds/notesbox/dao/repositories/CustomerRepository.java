package com.dds.notesbox.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.users.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CustomerRepository implements Dao<Customer> {
  @PersistenceContext
  private EntityManager em;


  public List<Customer> findAll() {
    String query = "FROM Customer";
    List<Customer> resultado = em.createQuery(query, Customer.class).getResultList();
    return resultado;
  }

  public Customer findOne(final Long id) {
    return em.find(Customer.class, id);
  }

  public Customer createOrMerge(Customer entity) {
    return em.merge(entity);
  }
 
  public Customer update(Customer entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    Customer usuario = em.find(Customer.class, id);
    em.remove(usuario);
  }
}
