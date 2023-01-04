package com.notesbox.models.users;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
  @Column(nullable = false)
  private String name;

  @Column(name = "hashed_password", nullable = false)
  private String hashedPassword;

  @Column(nullable = false)
  private String email;

  
  public User(String name, String nonHashedPassword, String email) {
    this.name = name;
    try {
      this.hashedPassword = Hasher.hashPassword(nonHashedPassword);
    } catch (NoSuchAlgorithmException nsa) {
      System.out.println(nsa);
    }
    this.email = email;
  }
  
  
}
