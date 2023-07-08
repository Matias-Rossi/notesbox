package com.dds.notesbox.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dds.notesbox.dao.repositories.CustomerRepository;
import com.dds.notesbox.dao.repositories.UserRepositoryInt;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Customer;
import com.dds.notesbox.models.users.User;
import com.dds.notesbox.security.AuthCredentials;
import com.dds.notesbox.security.JWTAuthenticationFilter;
import com.dds.notesbox.services.AuthService;
import com.dds.notesbox.services.AuthStatus;
import com.dds.notesbox.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
  
  @Autowired
  private UserRepositoryInt userRepository;

  @Autowired
  JWTAuthenticationFilter authFilter;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired 
  private AuthService authService;

  @Autowired
  private JWTUtil jwtUtil;

  @PostMapping(value ="api/auth/login")
  public String login(@RequestBody AuthCredentials credentials) {
    System.out.println("Raw credentials: " + credentials.getEmail() + " : " + credentials.getPassword());
    
    
    try {
      System.out.println("ENTDANDO A ATTEMPTAUTH");
      String token = authFilter.attemptAuthentication(credentials);
      if(!token.equals("")) {
        //LOGIN OK
        Optional<User> user = userRepository.findOneByEmail(credentials.getEmail());
        return jwtUtil.create(user.get().getId().toString(), user.get().getEmail());
      } else {
        return "Error: token vacío";
      }
    } catch (AuthenticationException ex) {
      return "Error: AuthenticationException ";
    }
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
  
  public HttpServletRequest getRequest() {
    return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
  }
  public HttpServletResponse getResponse() {
    return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
  }

}
