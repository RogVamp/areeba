package com.areeba.api.service;

import java.util.List;

import com.areeba.api.model.Customer;

public interface CustomerServiceInterface {
	public Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer updateCustomer(int id, Customer customer);
	void deleteCustomer(int id);
}
