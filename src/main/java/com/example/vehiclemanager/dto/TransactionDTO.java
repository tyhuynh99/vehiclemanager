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
    private String firstname;
    private String lastname;
    private String phoneNo;

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", bodyStyle='" + bodyStyle + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
