package com.demov2.apisablon.repository;

import com.demov2.apisablon.model.Category;
import com.demov2.apisablon.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findProductByProductName(String productName);

    @Query(value = "SELECT * FROM product p WHERE is_active=1 AND is_deleted = 0",nativeQuery = true)
    public List<Product> getProductList();
}
