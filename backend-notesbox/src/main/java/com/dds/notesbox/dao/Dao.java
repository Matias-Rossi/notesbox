package com.dds.notesbox.dao;

import java.util.List;

public interface Dao<T> {
  List<T> findAll();

  T findOne(Long id);
  
  void delete(Long id);

  T createOrMerge(T entity);

  T update(T entity);
}
