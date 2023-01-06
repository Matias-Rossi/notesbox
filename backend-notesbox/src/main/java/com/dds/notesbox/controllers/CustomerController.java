package com.dds.notesbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dds.notesbox.dao.repositories.CustomerRepository;
import com.dds.notesbox.models.users.Customer;

@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @RequestMapping(value = "api/customers")
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

}
