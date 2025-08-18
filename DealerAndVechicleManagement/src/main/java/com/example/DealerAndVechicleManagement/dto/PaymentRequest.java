package com.example.DealerAndVechicleManagement.dto;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long dealerId;
    private Double amount;
    private String method;
}