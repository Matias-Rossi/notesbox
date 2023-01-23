package com.dds.notesbox.services;

import lombok.Getter;

public enum AuthStatus {
  SUCCESS("Success"),
  EMAIL_IN_USE("Email already in use"),
  UNSAFE_PASSWORD("Password does not comply with requirements"),
  INVALID_CREDENTIALS("One or more credentials are not correct"),
  UNKNOWN_ERROR("An unknown error happened");

  @Getter
  private final String description;

  private AuthStatus(String description) {
    this.description = description;
  }
}
