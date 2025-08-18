package com.example.DealerAndVechicleManagement.service;

import com.example.DealerAndVechicleManagement.dto.CreateVehicleRequest;
import com.example.DealerAndVechicleManagement.dto.UpdateVehicleRequest;
import com.example.DealerAndVechicleManagement.dto.VehicleDto;
import com.example.DealerAndVechicleManagement.mapper.SubscriptionType;
import com.example.DealerAndVechicleManagement.mapper.VehicleMapper;
import com.example.DealerAndVechicleManagement.model.Dealer;
import com.example.DealerAndVechicleManagement.model.Vehicle;
import com.example.DealerAndVechicleManagement.repository.DealerRepository;
import com.example.DealerAndVechicleManagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    // CREATE
    public VehicleDto createVehicle(CreateVehicleRequest request) {
        // First, find the dealer that this vehicle will belong to.
        Dealer dealer = dealerRepository.findById(request.getDealerId())
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + request.getDealerId()));

        // Create a new Vehicle entity
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(request.getModel());
        vehicle.setPrice(request.getPrice());
        vehicle.setStatus(request.getStatus());
        vehicle.setDealer(dealer); // Link the vehicle to the dealer

        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toDto(savedVehicle);
    }

    // READ (All)
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    // READ (by ID)
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        return vehicleMapper.toDto(vehicle);
    }

    // UPDATE
    public VehicleDto updateVehicle(Long id, UpdateVehicleRequest request) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

        vehicleMapper.updateFromDto(request, existingVehicle);

        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        return vehicleMapper.toDto(updatedVehicle);
    }

    // DELETE
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    // The special method from the original task
    public List<VehicleDto> getVehiclesFromPremiumDealers() {
        List<Vehicle> vehicles = vehicleRepository.findByDealerSubscriptionType(SubscriptionType.PREMIUM);
        return vehicles.stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }
}