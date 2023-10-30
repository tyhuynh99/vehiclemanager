package com.example.vehiclemanager.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class BuyVehicleInfo {
    @NotEmpty(message = "VIN must not be blank")
    private String vin;
    @Min(value = 1, message = "Price must be greater than or equal 1")
    private Double price;
    @NotEmpty(message = "Buyer firstname must not be blank")
    private String firstname;
    @NotEmpty(message = "Buyer lastname must not be blank")
    private String lastname;
    @Pattern(regexp = "^[1-9][0-9]{10}$", message = "Phone number must have 11 number characters")
    private String phoneNo;
}
