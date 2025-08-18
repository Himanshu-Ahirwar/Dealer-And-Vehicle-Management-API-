package com.example.DealerAndVechicleManagement.dto;

import lombok.Data;

@Data
public class DealerDto {
    private Long id;
    private String name;
    private String email;
    private String subscriptionType; // Sending as a simple string
}