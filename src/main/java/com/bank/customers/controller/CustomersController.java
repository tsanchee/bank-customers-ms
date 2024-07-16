package com.bank.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customers.document.Customer;
import com.bank.customers.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "")
    public Flux<Customer> getCustomers(){
        return customerService.getCustomers();
    }
	
	@PostMapping(value = "")
	@ResponseBody Mono<Customer> addCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);
	}
	
	@PutMapping(value= "")
	@ResponseBody Mono<Customer> editCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);
	}
	
	@DeleteMapping(value="/{id}")
	public Mono<ResponseEntity<Customer>> deletedCustomerById(@PathVariable String id){
		
		return customerService.getCustomerById(id).flatMap(customer -> customerService.deletedCustomerById(customer))
                .map(c -> ResponseEntity
                        .noContent().build());
	}
	
	@GetMapping(value = "/types/{customerType}")
    public Flux<Customer> getCustomersByType(@PathVariable String customerType ){
        return customerService.getCustomersByCustomersType(customerType);
    }
	
	@GetMapping(value = "/emails/{email}")
    public Mono<Customer> getCustomerByEmail(@PathVariable String email ){
        return customerService.getCustomerByEmail(email);
    }
	
	@GetMapping(value = "/docs/{docNumber}")
    public Mono<Customer> getCustomerByDocNumber(@PathVariable String docNumber ){
        return customerService.getCustomerByDocNumber(docNumber);
    }
}
