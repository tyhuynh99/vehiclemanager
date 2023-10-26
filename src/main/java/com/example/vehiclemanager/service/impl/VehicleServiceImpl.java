package com.example.vehiclemanager.service.impl;

import com.example.vehiclemanager.dto.VehicleDTO;
import com.example.vehiclemanager.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public boolean create(VehicleDTO dto) {
        return false;
    }

    @Override
    public VehicleDTO update(VehicleDTO dto) {
        return null;
    }

    @Override
    public List<VehicleDTO> findAll() {
        List<VehicleDTO> vehicleList = new ArrayList<>();
        return vehicleList;
    }
}
