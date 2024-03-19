package com.demov2.apisablon.service;

import com.demov2.apisablon.exception.ApiException;
import com.demov2.apisablon.model.Category;
import com.demov2.apisablon.model.Customer;
import com.demov2.apisablon.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //GET - getCustomerById
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ApiException("Müşteri Bulunamadı.", HttpStatus.NOT_FOUND));
    }
}
