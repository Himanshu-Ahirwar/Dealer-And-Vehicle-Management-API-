package com.example.DealerAndVechicleManagement.controller;

import com.example.DealerAndVechicleManagement.dto.CreateVehicleRequest;
import com.example.DealerAndVechicleManagement.dto.UpdateVehicleRequest;
import com.example.DealerAndVechicleManagement.dto.VehicleDto;
import com.example.DealerAndVechicleManagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody CreateVehicleRequest request) {
        VehicleDto createdVehicle = vehicleService.createVehicle(request);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }



    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id, @RequestBody UpdateVehicleRequest request) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    // The special endpoint from the original task
    @GetMapping("/premium-dealers")
    public ResponseEntity<List<VehicleDto>> getVehiclesFromPremiumDealers() {
        return ResponseEntity.ok(vehicleService.getVehiclesFromPremiumDealers());
    }
}