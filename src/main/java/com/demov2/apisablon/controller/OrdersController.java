package com.demov2.apisablon.controller;

import com.demov2.apisablon.dto.request.OrdersRequest;
import com.demov2.apisablon.service.OrdersService;
import com.demov2.apisablon.util.core.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/getOrderByCustomersId/{customersId}")
    public ApiResponse getOrderByCustomersId(@PathVariable Long customersId) {
        return ApiResponse.ok(ordersService.getOrderByCustomersId(customersId), "Sipariş Bulundu.");
    }

    @PostMapping("/createOrder")
    public ApiResponse createOrder(@RequestBody OrdersRequest ordersRequest) {
        ordersService.createOrder(ordersRequest);
        return ApiResponse.ok(null, "Sipariş Başarıyla Eklendi.");
    }
}
