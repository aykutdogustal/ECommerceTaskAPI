package com.demov2.apisablon.controller;

import com.demov2.apisablon.service.CustomerService;
import com.demov2.apisablon.util.core.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomerById/{customerId}")
    public ApiResponse getCustomerById(@PathVariable Long customerId) {
        return ApiResponse.ok(customerService.getCustomerById(customerId), "Müşteri Bulundu");
    }
}
