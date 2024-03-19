package com.demov2.apisablon.repository;

import com.demov2.apisablon.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value = "SELECT * FROM orders_detail od WHERE od.orders_id = ?1",nativeQuery = true)
    public List<OrderDetail> getOrderDetailByOrdersId(Long orders_Id);
}
