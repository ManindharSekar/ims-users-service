package com.ims.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.users.dto.CustomerDTO;
import com.ims.users.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerApi {
	
	private final CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
		return ResponseEntity.ok(createdCustomer);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody CustomerDTO customerDTO) {
		CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id) {
		CustomerDTO customer = customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllCustomers() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(customerService.getAllCustomers());
	}

}
