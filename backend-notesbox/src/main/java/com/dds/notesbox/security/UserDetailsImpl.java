package com.dds.notesbox.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dds.notesbox.models.users.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

  private final User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    //TODO Roles and permissions
    return Collections.emptyList();
  }

  @Override
  public String getPassword() {
    return user.getHashedPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

  public String getName() {
    return user.getName();
  }
}
