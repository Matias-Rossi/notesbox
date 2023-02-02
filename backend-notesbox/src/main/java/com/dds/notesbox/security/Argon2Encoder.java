package com.dds.notesbox.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2Encoder implements PasswordEncoder {
  public String encode(CharSequence nonHashedPassword) {
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    return argon2.hash(1, 1024, 1, nonHashedPassword.toString().toCharArray());
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    boolean isPasswordValid = argon2.verify(encodedPassword, rawPassword.toString().toCharArray());

    return isPasswordValid;
  }  
}
