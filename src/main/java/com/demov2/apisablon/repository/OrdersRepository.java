package com.demov2.apisablon.repository;

import com.demov2.apisablon.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    @Query(value = "SELECT * FROM orders o WHERE o.customers_id = ?1",nativeQuery = true)
    Orders getOrderByCustomersId(Long customersId);

}
