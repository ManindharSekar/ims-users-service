package com.ims.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.users.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
