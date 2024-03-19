package com.demov2.apisablon.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "addressId", nullable = false)
    private long addressId;

    @Column(name = "addressLine")
    private String addressLine;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customersId")
    private Customer customers;
}
