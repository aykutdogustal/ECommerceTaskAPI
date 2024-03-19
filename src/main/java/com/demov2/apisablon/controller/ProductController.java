package com.demov2.apisablon.controller;

import com.demov2.apisablon.dto.request.CategoryRequest;
import com.demov2.apisablon.dto.request.ProductRequest;
import com.demov2.apisablon.repository.ProductRepository;
import com.demov2.apisablon.service.ProductService;
import com.demov2.apisablon.util.core.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/getProductById/{productId}")
    public ApiResponse getProductById(@PathVariable Long productId) {
        return ApiResponse.ok(productService.getProductById(productId), "Product/Ürün Bulundu");
    }

    @GetMapping("/getProductList")
    public ApiResponse getProductList(){
        return ApiResponse.ok(productService.getProductList(),"Tüm Ürün Listesi");
    }

    @PostMapping("/createProduct")
    public ApiResponse createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return ApiResponse.ok(null, "Ürün Başarıyla Eklendi.");
    }
}
