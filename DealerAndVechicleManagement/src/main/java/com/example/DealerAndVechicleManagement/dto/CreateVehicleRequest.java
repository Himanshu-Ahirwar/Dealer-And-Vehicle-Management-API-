package com.example.DealerAndVechicleManagement.dto;


import com.example.DealerAndVechicleManagement.mapper.VehicleStatus;
import lombok.Data;

@Data
public class CreateVehicleRequest {
    private String model;
    private Double price;
    private VehicleStatus status;
    private Long dealerId; // ID of the dealer this vehicle belongs to
}