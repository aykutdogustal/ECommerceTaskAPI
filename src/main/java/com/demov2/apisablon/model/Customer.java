package com.demov2.apisablon.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", nullable = false)
    private long customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
}
