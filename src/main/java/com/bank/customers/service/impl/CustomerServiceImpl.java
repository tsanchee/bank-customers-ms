package com.bank.customers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.customers.document.Customer;
import com.bank.customers.repository.CustomerRepository;
import com.bank.customers.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Transactional(readOnly = true)
	public Flux<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Flux<Customer> getCustomersByCustomersType(String customerType) {
		return customerRepository.findByCustomerType(customerType);
	}
	@Transactional
	public Mono<Customer> getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	@Transactional
	public Mono<Customer> getCustomerByDocNumber(String docNumber) {
		return customerRepository.findByDocNumber(docNumber);
	}
	@Transactional
	public Mono<Customer> addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	@Transactional
	public Mono<Customer> editCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	@Transactional
	public Mono<Void> deletedCustomerById(Customer customer) {
		return customerRepository.delete(customer);
	}

	@Transactional
	public Mono<Customer> getCustomerById(String id) {
		return customerRepository.findById(id);
	}

}
