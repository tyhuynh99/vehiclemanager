package com.example.vehiclemanager.controller;

import com.example.vehiclemanager.dto.VehicleDTO;
import com.example.vehiclemanager.dto.response.ListResponse;
import com.example.vehiclemanager.dto.response.ObjectResponse;
import com.example.vehiclemanager.service.VehicleService;
import com.example.vehiclemanager.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Operation(summary = "Get all vehicle in inventory", description = "Returns a list of vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping
    public ResponseEntity<ListResponse<VehicleDTO>> getAll(HttpServletRequest request) {
        List<VehicleDTO> vehicleList = service.findAll();
        ListResponse<VehicleDTO> response = ListResponse
                .<VehicleDTO>builder()
                .href(Utils.getUrl(request))
                .method(request.getMethod())
                .count(vehicleList.size())
                .items(vehicleList)
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a vehicle by vin", description = "Returns a vehicle as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The vehicle was not found")
    })
    @GetMapping("/{vin}")
    public ResponseEntity<ObjectResponse<VehicleDTO>> getByVin(
            @PathVariable
            @Parameter(name = "vin", description = "VIN of vehicle", example = "SCFAD01A65G953361")
            String vin,
            HttpServletRequest request) {
        VehicleDTO vehicleDTO = service.findByVin(vin);
        ObjectResponse<VehicleDTO> response = ObjectResponse
                .<VehicleDTO>builder()
                .href(Utils.getUrl(request))
                .method(request.getMethod())
                .data(vehicleDTO)
                .build();
        return ResponseEntity.ok(response);
    }
}
