package com.example.vehiclemanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionDTO {
    private Long id;
    private String vin;
    private Double price;
    private String name;
    private String brand;
    private String bodyStyle;
}
