package com.example.vehiclemanager.service;

import com.example.vehiclemanager.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    boolean create(VehicleDTO dto);

    VehicleDTO update(VehicleDTO dto);

    List<VehicleDTO> findAll();
}
