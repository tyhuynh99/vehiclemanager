package com.example.vehiclemanager.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@Entity(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vin", nullable = false)
    private String vin;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "body_style", nullable = false)
    private String bodyStyle;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstname;
    @Column(name = "last_name", length = 80, nullable = false)
    private String lastname;
    @Column(name = "phone_no", length = 11, nullable = false)
    private String phoneNo;
}
