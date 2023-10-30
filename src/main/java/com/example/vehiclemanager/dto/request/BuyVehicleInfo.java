package com.example.vehiclemanager.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyVehicleInfo {
    private String vin;
    private Double price;
    private String firstname;
    private String lastname;
    private String phoneNo;
}
