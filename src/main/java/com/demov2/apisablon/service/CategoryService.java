package com.demov2.apisablon.service;

import com.demov2.apisablon.dto.request.CategoryRequest;
import com.demov2.apisablon.exception.ApiException;
import com.demov2.apisablon.model.Category;
import com.demov2.apisablon.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    //GET - getCategoryById
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiException("Kategori Bulunamadı.", HttpStatus.NOT_FOUND));
    }

    //GET - GetCategoryList
    public List<Category> getCategoryList(){
        return categoryRepository.getCategoryList();
    }

    //Create - CreateCategory
    public void createCategory(CategoryRequest categoryRequest) {

        //Eklenecek kategori için Kategori Adına göre kontrol yapılıyor.
        Category categoryNameCheck = categoryRepository.findCategoryByCategoryName(categoryRequest.categoryName());
        if(categoryNameCheck != null){
            throw new ApiException("Kategori Zaten Kayıtlı.", HttpStatus.ALREADY_REPORTED);
        }
        //Kategori Ekleme işlemi.
        var category = new Category();
        category.setCategoryName(categoryRequest.categoryName());
        category.setCategoryDesc(categoryRequest.categoryDesc());
        categoryRepository.save(category);
    }

    //Update - UpdateCategory
    public void updateCategory(long categoryId, CategoryRequest categoryRequest){
        if (!categoryRepository.existsById(categoryId)) {
            throw new ApiException("Kategori Bulunamadı.", HttpStatus.NOT_FOUND);
        }

        final Category category = categoryRepository.findById(categoryId).get();

        category.setCategoryName(categoryRequest.categoryName());
        category.setCategoryDesc(categoryRequest.categoryDesc());
        categoryRepository.save(category);

    }

    //Delete  - DeleteCategoryById
    public void deleteCategoryById(Long categoryId){

        if (!categoryRepository.existsById(categoryId)) {
            throw new ApiException("Kategori Bulunamadı.", HttpStatus.NOT_FOUND);
        }

        final Category category = categoryRepository.findById(categoryId).get();
        category.setDeleted(true);
        category.setActive(false);
        categoryRepository.save(category);

    }
}
