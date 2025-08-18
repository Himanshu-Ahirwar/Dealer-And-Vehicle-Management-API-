package com.example.DealerAndVechicleManagement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment_transactions")
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dealerId;
    private Double amount;
    private String method; // e.g., "UPI", "Card", "NetBanking"
    private String status; // e.g., "PENDING", "SUCCESS", "FAILED"
    private LocalDateTime createdAt;
}