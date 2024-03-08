package com.vinayak.jpatest.controllers;

import com.vinayak.jpatest.beans.ResponseHandler;
import com.vinayak.jpatest.models.Customer;
import com.vinayak.jpatest.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseHandler.createResponse("Found Customers", HttpStatus.OK, customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseHandler.createResponse("Found Customer", HttpStatus.OK, customer);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.create(customer);
        return ResponseHandler.createResponse("Customer Created", HttpStatus.CREATED, createdCustomer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return String.valueOf(new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK));
    }
}
