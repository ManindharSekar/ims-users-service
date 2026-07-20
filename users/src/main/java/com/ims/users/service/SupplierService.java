package com.ims.users.service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ims.users.dto.SupplierDTO;
import com.ims.users.entity.Supplier;
import com.ims.users.repository.SupplierRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
	
	private final ModelMapper modelMapper;
	
	private final SupplierRepository supplierRepository;

	public SupplierDTO createSupplier(@Valid SupplierDTO supplierDTO) {
		// TODO Auto-generated method stub
		Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
		return modelMapper.map(supplierRepository.save(supplier), SupplierDTO.class);
	}

	public SupplierDTO updateSupplier(Long id, @Valid SupplierDTO supplierDTO) {
		// TODO Auto-generated method stub
		Supplier existingSupplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
		modelMapper.map(supplierDTO, existingSupplier);
		existingSupplier.setId(id);
		return modelMapper.map(supplierRepository.save(existingSupplier), SupplierDTO.class);
	}

	public void deleteSupplier(Long id) {
		// TODO Auto-generated method stub
		Supplier existingSupplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
		if (existingSupplier != null) {
			supplierRepository.delete(existingSupplier);
		}
		
	}

	public SupplierDTO getSupplierById(Long id) {
		// TODO Auto-generated method stub
		Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
		return modelMapper.map(supplier, SupplierDTO.class);
	}

	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		List<SupplierDTO> getAllSupplier = supplierRepository.findAll().stream().map(supplier -> modelMapper.map(supplier, SupplierDTO.class)).toList();
		return modelMapper.map(getAllSupplier, List.class);
	}

}
