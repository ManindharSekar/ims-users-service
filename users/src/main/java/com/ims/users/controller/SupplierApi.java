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

import com.ims.users.dto.SupplierDTO;
import com.ims.users.service.SupplierService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierApi {
	
	private final SupplierService supplierService;

	
	@PostMapping("/create")
	public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
		SupplierDTO createdSupplier = supplierService.createSupplier(supplierDTO);
		return ResponseEntity.ok(createdSupplier);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable("id") Long id, @Valid @RequestBody SupplierDTO supplierDTO) {
		SupplierDTO updatedSupplier = supplierService.updateSupplier(id, supplierDTO);
		return ResponseEntity.ok(updatedSupplier);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Long id) {
		supplierService.deleteSupplier(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable("id") Long id) {
		SupplierDTO supplier = supplierService.getSupplierById(id);
		return ResponseEntity.ok(supplier);
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllSuppliers() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(supplierService.getAllSuppliers());
	}
	
	

}
