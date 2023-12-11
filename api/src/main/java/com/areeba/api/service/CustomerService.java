package com.areeba.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.areeba.api.model.Customer;
import com.areeba.api.repository.CustomerRepository;


@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setEmail(customer.getEmail());
        return customerRepository.save(customerToUpdate);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}

}
