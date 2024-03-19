package com.demov2.apisablon.service;

import com.demov2.apisablon.dto.request.OrdersRequest;
import com.demov2.apisablon.exception.ApiException;
import com.demov2.apisablon.model.Orders;
import com.demov2.apisablon.repository.OrdersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final CustomerService customerService;

    public OrdersService(OrdersRepository ordersRepository,
                         CustomerService customerService) {
        this.ordersRepository = ordersRepository;
        this.customerService = customerService;
    }

    public Orders getOrderByCustomersId(Long customersId) {

        if(!ordersRepository.getOrderByCustomersId(customersId).isActive()){
            throw new ApiException("Aktif Şipariş Bilgisi Yoktur.", HttpStatus.BAD_REQUEST);
        }
        return ordersRepository.getOrderByCustomersId(customersId);
    }

    public Orders getOrderById(Long ordersId){
        return ordersRepository.findById(ordersId)
                .orElseThrow(() -> new ApiException("Sipariş Bulunamadı.", HttpStatus.NOT_FOUND));
    }

    //Create - createOrder
    public void createOrder(OrdersRequest ordersRequest) {
        var order = new Orders();
        var customer = customerService.getCustomerById(ordersRequest.customersId());
        order.setCustomers(customer);
        ordersRepository.save(order);
    }
}
