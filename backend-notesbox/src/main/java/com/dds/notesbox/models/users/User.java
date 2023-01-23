package com.dds.notesbox.models.users;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.dds.notesbox.models.PersistentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class User extends PersistentEntity {

  @Column(nullable = false) @Getter
  private String name;

  @Column(name = "hashed_password", nullable = false) @Getter @Setter
  private String hashedPassword;

  @Column(nullable = false) @Getter
  private String email;

  
  public User(String name, String hashedPassword, String email) {
    this.name = name;
    this.hashedPassword = hashedPassword;
    this.email = email;
  }
  
  public User(){}
}
