package com.example.vehiclemanager.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyVehicleInfo {
    private String vin;
    private Double price;
}
