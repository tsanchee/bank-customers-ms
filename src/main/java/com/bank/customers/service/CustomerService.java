package com.bank.customers.service;

import com.bank.customers.document.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	
	public Flux<Customer> getCustomers();
	public Mono<Customer> getCustomerById(String id);
	public Flux<Customer> getCustomersByCustomersType(String customerType);
	public Mono<Customer> getCustomerByEmail(String email);
	public Mono<Customer> getCustomerByDocNumber(String docNumber);
	public Mono<Customer> addCustomer(Customer customer);
	public Mono<Customer> editCustomer(Customer customer);
	public Mono<Void> deletedCustomerById(Customer customer);
	
}
