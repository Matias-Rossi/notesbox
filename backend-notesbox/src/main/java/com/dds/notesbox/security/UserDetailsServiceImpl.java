package com.dds.notesbox.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dds.notesbox.dao.repositories.UserRepositoryInt;
import com.dds.notesbox.models.users.User;;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepositoryInt userRepositoryInt;

  @Value("${spring.security.user.name}")
  private String adminUsername;

  @Value("${spring.security.user.password}")
  private String adminPassword;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    System.out.println(">>>>>>>>>> INICIO CON USERNAME " + adminUsername + " <<<<<<<<<<<<");
    //Admin
    if(email.equals(adminUsername)) {
      System.out.println(">>>>>>>>>> ADMIN INICIALIZADO <<<<<<<<<<<<");
      User admin = new User(adminUsername, adminPassword, adminUsername);
      return new UserDetailsImpl(admin);
    }

    //Other users
    User user = userRepositoryInt.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " does not exist.") );
    return new UserDetailsImpl(user);
  }

}
