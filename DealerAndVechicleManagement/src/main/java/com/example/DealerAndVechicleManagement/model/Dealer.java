package com.example.DealerAndVechicleManagement.model;


import com.example.DealerAndVechicleManagement.mapper.SubscriptionType;
import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok annotation for getters, setters, etc.
@Entity
@Table(name = "dealers")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING) // Stores the enum as a string ("BASIC", "PREMIUM")
    private SubscriptionType subscriptionType;
}
