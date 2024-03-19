package com.demov2.apisablon.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "category")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", nullable = false)
    private long categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "categoryDesc")
    private String categoryDesc;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
}
