package com.dds.notesbox.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dds.notesbox.dao.repositories.AddressRepository;
import com.dds.notesbox.dao.repositories.CustomerRepository;
import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.models.orders.Order;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Customer;
import com.dds.notesbox.models.users.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class AuthService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private AddressRepository addressRepository;

  public String hashPassword(String nonHashedPassword) {
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    return argon2.hash(1, 1024, 1, nonHashedPassword.toCharArray());
  }

  public AuthStatus signupCustomer(Customer customer, Address address) {
    //TODO Check password

    //Check email
    if(emailAlreadyInUse(customer.getEmail())) {
      return AuthStatus.EMAIL_IN_USE;
    }

    String hashedPassword = hashPassword(customer.getHashedPassword());
    customer.setHashedPassword(hashedPassword);
    
    address.setCustomer(customer);
    customer.setShippingAddress(address); //TODO For some reason address_id in Customer won't be set
    address.setOrders(new ArrayList<Order>());
    
    customerRepository.persist(customer);
    addressRepository.persist(address);

    return AuthStatus.SUCCESS;
  }

  private boolean emailAlreadyInUse(String email) {
    return userRepository.isEmailInUse(email);
  }

}
