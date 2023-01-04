package com.notesbox.models.users;

import java.security.NoSuchAlgorithmException;

public class Admin extends User {

  public Admin(String name, String nonHashedPassword, String email) throws NoSuchAlgorithmException {
    super(name, nonHashedPassword, email);
  }
  
}
