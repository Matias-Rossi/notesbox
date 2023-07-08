package com.dds.notesbox.dao.repositories;

import com.dds.notesbox.dao.Dao;
import com.dds.notesbox.models.products.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductRepository implements Dao<Product> {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll() {
        String query = "FROM Product";
        List<Product> result = em.createQuery(query, Product.class).getResultList();
        return result;
    }

    public Product findOne(final Long id) {
        return em.find(Product.class, id);
    }

    public void persist(Product entity) {
        em.persist(entity);
    }

    public Product update(Product entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }

}
