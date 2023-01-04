package com.notesbox.models;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.notesbox.models.users.Hasher;

public class HasherTest {

  @Test
  @DisplayName("Hash a password and compare it to the unhashed")
  public void compare_password() {
    String password = "abcdefgh";
    try {
      String hashed = Hasher.hashPassword(password);
      assertTrue(Hasher.checkPassword("abcdefgh", hashed));
    } catch (NoSuchAlgorithmException e) {
      fail("NoSuchAlgorighm");
    }
  }
}
