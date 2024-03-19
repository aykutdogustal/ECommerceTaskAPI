package com.demov2.apisablon.controller;

import com.demov2.apisablon.dto.request.CategoryRequest;
import com.demov2.apisablon.service.CategoryService;
import com.demov2.apisablon.service.ProductService;
import com.demov2.apisablon.util.core.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/getCategoryById/{categoryId}")
    public ApiResponse getCategoryById(@PathVariable Long categoryId) {
        return ApiResponse.ok(categoryService.getCategoryById(categoryId), "Category/Kategori Bulundu");
    }

    @GetMapping("/getCategoryList")
    public ApiResponse getCategoryList(){
        return ApiResponse.ok(categoryService.getCategoryList(),"Tüm Kategori Listesi");
    }
    @PostMapping("/createCategory")
    public ApiResponse createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
        return ApiResponse.ok(null, "Kategori Başarıyla Eklendi.");
    }

    @PutMapping("/updateCategory/{categoryId}")
    public ApiResponse updateCategory(@PathVariable Long categoryId , @RequestBody CategoryRequest categoryRequest){
        categoryService.updateCategory(categoryId,categoryRequest);
        return ApiResponse.ok(null,"Kategori Başarıyla Güncelledi.");
    }

    @DeleteMapping("/deleteCategoryById/{categoryId}")
    public ApiResponse deleteCategoryById (@PathVariable Long categoryId){
        categoryService.deleteCategoryById(categoryId);
        return ApiResponse.ok(null,"Kategori Başarıyla Silindi.");
    }
}
