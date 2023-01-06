package com.dds.notesbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.UserRepository;
import com.dds.notesbox.models.users.Address;
import com.dds.notesbox.models.users.Customer;

@RestController
public class SampleDataController {

  @Autowired
  private UserRepository userRepository;
  
  @RequestMapping(value = "api/test/users/create-sample-data")
  public String createSampleUsers() {
    Address a1 = new Address("Rivadavia", "210", "Buenos Aires", "CABA", "Argentina", null, null);
    Customer c1 = new Customer("Matias Rossi", "contraseña", "mr@mail.com", a1);
    userRepository.createOrMerge(c1);

    return "Data created";
  }
}
