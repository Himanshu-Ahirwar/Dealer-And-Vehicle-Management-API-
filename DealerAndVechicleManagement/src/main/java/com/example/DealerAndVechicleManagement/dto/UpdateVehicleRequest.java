package com.example.DealerAndVechicleManagement.dto;

import com.example.DealerAndVechicleManagement.mapper.VehicleStatus;
import lombok.Data;

@Data
public class UpdateVehicleRequest {
    private String model;
    private Double price;
    private VehicleStatus status;
}