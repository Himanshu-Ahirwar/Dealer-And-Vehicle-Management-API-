package com.example.DealerAndVechicleManagement.dto;

import lombok.Data;

@Data
public class UpdateDealerRequest {
    private String name;
    private String email;
    private String subscriptionType;
}