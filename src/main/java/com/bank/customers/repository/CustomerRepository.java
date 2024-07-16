package com.bank.customers.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.customers.document.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
	Mono<Customer> findByDocNumber(String docNumber);
	Flux<Customer> findByCustomerType(String customerType);
	Mono<Customer> findByEmail(String email);
	//Mono<Void> deleteById(String id);
}
