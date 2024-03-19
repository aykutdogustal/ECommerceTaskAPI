package com.demov2.apisablon.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "ordersDetail")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordersDetailId", nullable = false)
    private Long ordersDetailId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productsId")
    private Product products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_Id")
    private Orders orders;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
