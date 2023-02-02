package com.dds.notesbox.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.dao.repositories.UserRepositoryInt;
import com.dds.notesbox.models.users.User;;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepositoryInt userRepositoryInt;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepositoryInt.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " does not exist.") );
    return new UserDetailsImpl(user);
  }
}
