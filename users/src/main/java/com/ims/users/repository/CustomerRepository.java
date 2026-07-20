package com.ims.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.users.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
