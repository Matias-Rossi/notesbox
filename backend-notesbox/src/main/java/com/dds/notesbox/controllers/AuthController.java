package com.dds.notesbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.AddressRepository;
import com.dds.notesbox.dao.repositories.CustomerRepository;
import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Customer;
import com.dds.notesbox.models.users.User;
import com.dds.notesbox.services.AuthService;
import com.dds.notesbox.services.AuthStatus;
import com.dds.notesbox.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class AuthController {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired 
  private AuthService authService;

  @Autowired
  private JWTUtil jwtUtil;

  @PostMapping(value ="api/login")
  public String login(@RequestBody User user) {
    User fetchedUser = userRepository.getUserByCredentials(user);

    
    if (fetchedUser == null) {
      return "FAIL";
    }

    //LOGIN OK

    return jwtUtil.create(fetchedUser.getId().toString(), fetchedUser.getEmail());
  }

  static class CustomerAndAddress {
    public Customer customer;
    public Address address;
  }

  @PostMapping(value = "api/signup")
  public ResponseEntity<String> signupCustomer(@RequestBody CustomerAndAddress customerAndAddress) {
    Customer customer = customerAndAddress.customer;
    Address address = customerAndAddress.address;
    AuthStatus authStatus = authService.signupCustomer(customer, address);

    HttpStatus httpStatus = null;
    switch(authStatus) {
      case SUCCESS: httpStatus = HttpStatus.CREATED; break;
      case EMAIL_IN_USE: httpStatus = HttpStatus.CONFLICT; break;
      case INVALID_CREDENTIALS: httpStatus = HttpStatus.FORBIDDEN; break;
      case UNSAFE_PASSWORD: httpStatus = HttpStatus.FORBIDDEN; break;
      default: httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return new ResponseEntity<>(authStatus.getDescription(), httpStatus);
  } 
  

}
