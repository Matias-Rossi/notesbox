package com.dds.notesbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.models.users.User;

@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "api/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  
}
