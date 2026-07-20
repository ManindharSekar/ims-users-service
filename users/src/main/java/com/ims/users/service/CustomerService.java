package com.ims.users.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ims.users.dto.CustomerDTO;
import com.ims.users.entity.Customer;
import com.ims.users.repository.CustomerRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	private final ModelMapper modelMapper;

	public CustomerDTO createCustomer(@Valid CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
	}

	public CustomerDTO updateCustomer(Long id, @Valid CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
		modelMapper.map(customerDTO, existingCustomer);
		existingCustomer.setId(id);
		return modelMapper.map(customerRepository.save(existingCustomer), CustomerDTO.class);
	}

	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
		if (existingCustomer != null) {
			customerRepository.delete(existingCustomer);
		}
		
	}

	public CustomerDTO getCustomerById(Long id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
		return modelMapper.map(customer, CustomerDTO.class);
	}

	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		List<CustomerDTO> getAllCustomer = customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).toList();
		return modelMapper.map(getAllCustomer, List.class);
	}
	
	

}
