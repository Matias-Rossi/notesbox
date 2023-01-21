package com.dds.notesbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.models.users.User;
import com.dds.notesbox.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class AuthController {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JWTUtil jwtUtil;

  @PostMapping(value ="api/login")
  public String login(@RequestBody User user) {
    User fetchedUser = userRepository.getUserByCredentials(user);

    
    if (fetchedUser == null) {
      return "FAIL";
    }

    //LOGIN OK

    return jwtUtil.create(fetchedUser.getId().toString(), fetchedUser.getEmail());
  }

  @PostMapping(value = "api/signup")
  public void signup(@RequestBody User user) {
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    String hash = argon2.hash(1, 1024, 1, user.getHashedPassword().toCharArray());
    //                                                Which isn't actually hashed yet ^
    user.setHashedPassword(hash);

    userRepository.persist(user);
  } 
  

}
