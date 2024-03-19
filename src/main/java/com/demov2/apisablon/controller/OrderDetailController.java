package com.demov2.apisablon.controller;

import com.demov2.apisablon.dto.request.CategoryRequest;
import com.demov2.apisablon.dto.request.OrderDetailRequest;
import com.demov2.apisablon.service.OrderDetailService;
import com.demov2.apisablon.util.core.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/getOrderDetailByOrdersId/{orders_Id}")
    public ApiResponse getOrderDetailByOrdersId(@PathVariable Long orders_Id) {
        return ApiResponse.ok(orderDetailService.getOrderDetailByOrdersId(orders_Id), "Sipariş Detayı Bulundu");
    }


    @PostMapping("/createOrderDetail")
    public ApiResponse createOrderDetail(@RequestBody OrderDetailRequest orderDetailRequest) {
        orderDetailService.createOrderDetail(orderDetailRequest);
        return ApiResponse.ok(null, "Sipariş Detayı Başarıyla Eklendi.");
    }
}
