package com.example.vehiclemanager.service.impl;

import com.example.vehiclemanager.dto.TransactionDTO;
import com.example.vehiclemanager.dto.request.BuyVehicleInfo;
import com.example.vehiclemanager.entity.Transaction;
import com.example.vehiclemanager.entity.Vehicle;
import com.example.vehiclemanager.repository.TransactionRepository;
import com.example.vehiclemanager.repository.VehicleRepository;
import com.example.vehiclemanager.service.MarketService;
import com.example.vehiclemanager.service.SlackService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j
public class MarketServiceImpl implements MarketService {
    private final VehicleRepository vehicleRepository;
    private final TransactionRepository transactionRepository;
    private final ObjectMapper mapper;

    private final SlackService slackService;

    public MarketServiceImpl(VehicleRepository vehicleRepository,
                             TransactionRepository transactionRepository,
                             ObjectMapper mapper, SlackService slackService) {
        this.vehicleRepository = vehicleRepository;
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
        this.slackService = slackService;
    }

    @Override
    public TransactionDTO buyVehicle(BuyVehicleInfo dto) {
        String vin = dto.getVin();

        Optional<Vehicle> vehicleOpt = vehicleRepository.findByVinAndIsBuyFalse(vin);
        if (vehicleOpt.isEmpty()) {
            String msg = String.format("Vehicle is not found with vin %s", vin);
            log.info(msg);
            throw new EntityNotFoundException(msg);
        }

        Vehicle vehicle = vehicleOpt.get();
        Transaction transaction = mapper.convertValue(vehicle, Transaction.class);
        transaction.setPrice(dto.getPrice());
        transaction.setFirstname(dto.getFirstname());
        transaction.setLastname(dto.getLastname());
        transaction.setPhoneNo(dto.getPhoneNo());

        transaction = transactionRepository.save(transaction);
        TransactionDTO transactionDto = mapper.convertValue(transaction, TransactionDTO.class);

        notifyBuyVehicle(transactionDto);

        return transactionDto;
    }

    private void notifyBuyVehicle(TransactionDTO dto) {
        StringBuilder message = new StringBuilder("Transaction has been made. ");
        message.append("Detail: ");
        message.append(dto.toString());
        slackService.sendSlackNotification(message.toString());
    }
}
