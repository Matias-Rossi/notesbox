package com.dds.notesbox.models.users;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Admin extends User {

  public Admin(String name, String hashedPassword, String email) {
    super(name, hashedPassword, email);
  }

  public Admin(){
    super();
  }
  
}
