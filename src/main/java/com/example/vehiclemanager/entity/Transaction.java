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
    @Column(name = "vin")
    private String vin;
    @Column(name = "price")
    private Double price;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "body_style")
    private String bodyStyle;
}
