package com.example.DealerAndVechicleManagement.model;

import com.example.DealerAndVechicleManagement.mapper.VehicleStatus;
import lombok.Data; // <-- Make sure this import is present
import jakarta.persistence.*;

@Data // <-- This is the fix. It automatically creates getDealer(), getId(), etc.
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Double price;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;
}