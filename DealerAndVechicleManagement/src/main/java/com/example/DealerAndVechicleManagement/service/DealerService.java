package com.example.DealerAndVechicleManagement.service;

import com.example.DealerAndVechicleManagement.dto.CreateDealerRequest;
import com.example.DealerAndVechicleManagement.dto.DealerDto;
import com.example.DealerAndVechicleManagement.dto.UpdateDealerRequest;
import com.example.DealerAndVechicleManagement.mapper.DealerMapper;
import com.example.DealerAndVechicleManagement.model.Dealer;
import com.example.DealerAndVechicleManagement.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    @Autowired
    private DealerMapper dealerMapper;

    public DealerDto createDealer(CreateDealerRequest request) {
        Dealer dealer = dealerMapper.toEntity(request);
        Dealer savedDealer = dealerRepository.save(dealer);
        return dealerMapper.toDto(savedDealer);
    }

    public List<DealerDto> getAllDealers() {
        return dealerRepository.findAll()
                .stream()
                .map(dealerMapper::toDto)
                .collect(Collectors.toList());
    }

    // READ (by ID)
    public DealerDto getDealerById(Long id) {
        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + id));
        return dealerMapper.toDto(dealer);
    }

    // UPDATE
    public DealerDto updateDealer(Long id, UpdateDealerRequest request) {
        Dealer existingDealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + id));

        dealerMapper.updateFromDto(request, existingDealer);

        Dealer updatedDealer = dealerRepository.save(existingDealer);
        return dealerMapper.toDto(updatedDealer);
    }

    // DELETE
    public void deleteDealer(Long id) {
        if (!dealerRepository.existsById(id)) {
            throw new RuntimeException("Dealer not found with id: " + id);
        }
        dealerRepository.deleteById(id);
    }
}