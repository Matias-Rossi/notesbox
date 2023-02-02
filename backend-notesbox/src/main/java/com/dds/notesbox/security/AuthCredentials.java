package com.dds.notesbox.security;

import lombok.Data;

@Data
public class AuthCredentials {
  private String email;
  private String password;
}
