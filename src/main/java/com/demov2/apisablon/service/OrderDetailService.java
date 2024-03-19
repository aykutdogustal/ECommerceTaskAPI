package com.demov2.apisablon.service;

import com.demov2.apisablon.dto.request.OrderDetailRequest;
import com.demov2.apisablon.exception.ApiException;
import com.demov2.apisablon.model.OrderDetail;
import com.demov2.apisablon.repository.OrderDetailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrdersService ordersService;

    private final ProductService productService;

    public OrderDetailService(OrderDetailRepository orderDetailRepository,
                              OrdersService ordersService,
                              ProductService productService) {
        this.orderDetailRepository = orderDetailRepository;
        this.ordersService = ordersService;
        this.productService = productService;
    }

    public List<OrderDetail> getOrderDetailByOrdersId(Long orders_Id) {
        if(!ordersService.getOrderById(orders_Id).isActive()){
            throw new ApiException("Aktif Şipariş Bilgisi Yoktur.", HttpStatus.BAD_REQUEST);
        }
        if(orderDetailRepository.getOrderDetailByOrdersId(orders_Id).isEmpty()){
            throw new ApiException("Aktif Şipariş Detay Bilgisi Yoktur.", HttpStatus.BAD_REQUEST);
        }
        return orderDetailRepository.getOrderDetailByOrdersId(orders_Id);
    }

    //Create - createOrderDetail
    public void createOrderDetail(OrderDetailRequest orderDetailRequest) {

        var orderDetail = new OrderDetail();

        var order = ordersService.getOrderById(orderDetailRequest.orders_Id());
        var product = productService.getProductById(orderDetailRequest.productsId());

        orderDetail.setOrders(order);
        orderDetail.setProducts(product);
        orderDetailRepository.save(orderDetail);
    }
}
