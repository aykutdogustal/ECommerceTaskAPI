package com.demov2.apisablon.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordersId", nullable = false)
    private long ordersId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customersId")
    private Customer customers;

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
}
