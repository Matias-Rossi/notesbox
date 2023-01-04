package com.notesbox.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class Repository<T> {
  private EntityManager em;
  private final Class<T> _class;

  public Repository(EntityManager em, Class<T> _class) {
    this.em = em;
    this._class = _class;
  }

  @SuppressWarnings("unchecked")
  public T getById(long id) {
    CriteriaBuilder cb = this.em.getCriteriaBuilder();
    CriteriaQuery<T> cr = cb.createQuery(this._class);
    Root<T> root = cr.from(this._class);
    Predicate predicate = cb.equal(root.get("id"), id);
    cr.where(predicate);

    Query query = this.em.createQuery(cr);
  
    return (T) query.getSingleResult();  
  }  

  @SuppressWarnings("unchecked")
  public List<T> getAll() {
    CriteriaBuilder cb = this.em.getCriteriaBuilder();
    CriteriaQuery<T> cr = cb.createQuery(this._class);
    
    Query query = this.em.createQuery(cr);
  
    return (List<T>) query.getResultList();  
  }

  public List<T> getAllSubset(int startIndex, int endIndex) {
    List<T> list = getAll();
    return list.subList(startIndex, endIndex);
  }

  public void add(T item) {
    em.persist(item);
  }


}
