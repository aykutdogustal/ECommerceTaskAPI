package com.demov2.apisablon.service;

import com.demov2.apisablon.dto.request.ProductRequest;
import com.demov2.apisablon.exception.ApiException;
import com.demov2.apisablon.model.Product;
import com.demov2.apisablon.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;
    public ProductService(ProductRepository productRepository,
                          CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    //Get - GetProductById
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ApiException("Ürün Bulunamadı.", HttpStatus.NOT_FOUND));
    }

    //GET - GetProductList
    public List<Product> getProductList(){
        return productRepository.getProductList();
    }

    //Create - CreateProduct
    public void createProduct(ProductRequest productRequest) {
        Product productNameCheck = productRepository.findProductByProductName(productRequest.productName());
        if(productNameCheck != null){
            throw new ApiException("Ürün Zaten Kayıtlı.", HttpStatus.ALREADY_REPORTED);
        }
        var category = categoryService.getCategoryById(productRequest.categoriesId());

        var product = new Product();
        product.setProductName(productRequest.productName());
        product.setProductDesc(productRequest.productName());
        product.setProductPrice(productRequest.productName());
        product.setProductStock(productRequest.productStock());
        product.setCategories(category);
        productRepository.save(product);
    }

}
