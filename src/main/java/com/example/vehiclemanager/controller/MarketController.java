package com.example.vehiclemanager.controller;

import com.example.vehiclemanager.dto.TransactionDTO;
import com.example.vehiclemanager.dto.request.BuyVehicleInfo;
import com.example.vehiclemanager.dto.response.ObjectResponse;
import com.example.vehiclemanager.service.MarketService;
import com.example.vehiclemanager.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller("/market")
public class MarketController {
    private final MarketService service;

    public MarketController(MarketService service) {
        this.service = service;
    }

    @Operation(summary = "Buy a vehicle", description = "Returns a transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully buying")
    })
    @PostMapping(name = "/buy")
    public ResponseEntity<ObjectResponse<TransactionDTO>> buyVehicle(
            @RequestBody BuyVehicleInfo buyVehicleInfo,
            HttpServletRequest request) {
        TransactionDTO transactionDTO = service.buyVehicle(buyVehicleInfo);
        ObjectResponse<TransactionDTO> response = ObjectResponse.<TransactionDTO>builder()
                .href(Utils.getUrl(request))
                .method(request.getMethod())
                .data(transactionDTO)
                .build();
        return ResponseEntity.ok(response);
    }
}
