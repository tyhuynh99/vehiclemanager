package com.example.vehiclemanager.service.impl;

import com.example.vehiclemanager.dto.VehicleDTO;
import com.example.vehiclemanager.entity.Vehicle;
import com.example.vehiclemanager.repository.VehicleRepository;
import com.example.vehiclemanager.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;
    private final ObjectMapper mapper;
    public VehicleServiceImpl(VehicleRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

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
        List<VehicleDTO> vehicleList = repository.findAll()
                .stream()
                .map(x -> mapper.convertValue(x, VehicleDTO.class))
                .collect(Collectors.toList());
        log.info("Vehicle count: {}", vehicleList.size());
        return vehicleList;
    }

    @Override
    public VehicleDTO findByVin(String vin) {
        Optional<Vehicle> vehicle = repository.findById(vin);
        if (vehicle.isEmpty()) {
            String msg = String.format("Vehicle is not found with vin %s", vin);
            log.info(msg);
            throw new EntityNotFoundException(msg);
        }
        return mapper.convertValue(vehicle, VehicleDTO.class);
    }
}
