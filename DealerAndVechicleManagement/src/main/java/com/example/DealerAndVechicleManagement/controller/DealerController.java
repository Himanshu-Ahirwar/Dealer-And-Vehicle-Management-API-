package com.example.DealerAndVechicleManagement.controller;

import com.example.DealerAndVechicleManagement.dto.CreateDealerRequest;
import com.example.DealerAndVechicleManagement.dto.DealerDto;
import com.example.DealerAndVechicleManagement.dto.UpdateDealerRequest;
import com.example.DealerAndVechicleManagement.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @PostMapping
    public ResponseEntity<DealerDto> createDealer(@RequestBody CreateDealerRequest request) {
        return ResponseEntity.ok(dealerService.createDealer(request));
    }

    @GetMapping
    public ResponseEntity<List<DealerDto>> getAllDealers() {
        return ResponseEntity.ok(dealerService.getAllDealers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DealerDto> getDealerById(@PathVariable Long id) {
        return ResponseEntity.ok(dealerService.getDealerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DealerDto> updateDealer(@PathVariable Long id, @RequestBody UpdateDealerRequest request) {
        return ResponseEntity.ok(dealerService.updateDealer(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
        return ResponseEntity.noContent().build();
    }
}