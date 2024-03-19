package com.demov2.apisablon.repository;

import com.demov2.apisablon.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findCategoryByCategoryName(String categoryName);

    @Query(value = "SELECT * FROM category c WHERE is_active=1 AND is_deleted = 0",nativeQuery = true)
    public List<Category> getCategoryList();

}
