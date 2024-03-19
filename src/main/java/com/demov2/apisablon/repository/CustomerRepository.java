package com.demov2.apisablon.repository;

import com.demov2.apisablon.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
