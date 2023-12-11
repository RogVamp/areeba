package com.areeba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areeba.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
