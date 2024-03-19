package com.demov2.apisablon.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "productId", nullable = false)
    private long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDesc")
    private String productDesc;

    @Column(name = "productPrice")
    private String productPrice;

    @Column(name = "productStock")
    private int productStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoriesId")
    private Category categories;



    public Product(String productName, String productDesc, String productPrice, Category categories,int productStock) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.categories = categories;
        this.productStock = productStock;
    }

    public Product() {

    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategories() {
        return categories;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

}
