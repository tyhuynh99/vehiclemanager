package com.example.vehiclemanager.service;

import com.example.vehiclemanager.dto.TransactionDTO;
import com.example.vehiclemanager.dto.request.BuyVehicleInfo;

public interface MarketService {
    TransactionDTO buyVehicle(BuyVehicleInfo dto);
}
