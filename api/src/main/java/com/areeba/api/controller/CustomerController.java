package com.areeba.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areeba.api.model.Customer;
import com.areeba.api.service.CustomerService;


@RestController
@RequestMapping("/customer")
@CrossOrigin({"http://localhost:3000/"})
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}
	
	
	
}
