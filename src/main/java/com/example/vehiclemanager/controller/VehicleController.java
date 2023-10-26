package com.example.vehiclemanager.controller;

import com.example.vehiclemanager.dto.VehicleDTO;
import com.example.vehiclemanager.dto.response.ListResponse;
import com.example.vehiclemanager.service.VehicleService;
import com.example.vehiclemanager.util.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResponse<VehicleDTO>> getAll(HttpServletRequest request) {
        List<VehicleDTO> vehicleList = service.findAll();
        ListResponse<VehicleDTO> response = ListResponse.<VehicleDTO>builder()
                .href(Utils.getUrl(request))
                .count(vehicleList.size())
                .items(vehicleList)
                .build();
        return ResponseEntity.ok(response);
    }
}
