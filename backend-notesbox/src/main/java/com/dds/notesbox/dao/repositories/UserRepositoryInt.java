package com.dds.notesbox.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dds.notesbox.models.users.User;

public interface UserRepositoryInt extends JpaRepository<User, Integer> {
  Optional<User> findOneByEmail(String email);
}
