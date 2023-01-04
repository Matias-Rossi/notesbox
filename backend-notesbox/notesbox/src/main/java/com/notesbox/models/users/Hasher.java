package com.notesbox.models.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
  public static String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    messageDigest.update(password.getBytes());
    byte[] hash = messageDigest.digest();

    // Convert the hash value to a hexadecimal string
    StringBuilder hexString = new StringBuilder();
    for (byte b : hash) {
        hexString.append(String.format("%02x", b));
    }
    return hexString.toString();
  }

  public static boolean checkPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
    // Hash the password
    String passwordHash = hashPassword(password);

    // Compare the hashed password with the stored hash
    return passwordHash.equals(hashedPassword);
}
}
