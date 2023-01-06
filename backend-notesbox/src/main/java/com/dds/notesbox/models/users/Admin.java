package com.dds.notesbox.models.users;

import java.security.NoSuchAlgorithmException;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Admin extends User {

  public Admin(String name, String nonHashedPassword, String email) throws NoSuchAlgorithmException {
    super(name, nonHashedPassword, email);
  }

  public Admin(){
    super();
  }
  
}
