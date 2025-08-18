package com.example.DealerAndVechicleManagement.dto;


import lombok.Data;

@Data
public class VehicleDto {
    private Long id;
    private String model;
    private Double price;
    private String status;
    private Long dealerId; // Expose the foreign key ID
}