package com.example.DealerAndVechicleManagement.repository;


import com.example.DealerAndVechicleManagement.mapper.SubscriptionType;
import com.example.DealerAndVechicleManagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // This is the custom method for the special requirement.
    // Spring Data JPA creates the query automatically from the method name!
    List<Vehicle> findByDealerSubscriptionType(SubscriptionType subscriptionType);
}