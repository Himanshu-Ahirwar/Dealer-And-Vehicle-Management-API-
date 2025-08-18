package com.example.DealerAndVechicleManagement.mapper;

// src/main/java/com/example/demo/mapper/VehicleMapper.java
import com.example.DealerAndVechicleManagement.dto.UpdateVehicleRequest;
import com.example.DealerAndVechicleManagement.dto.VehicleDto;
import com.example.DealerAndVechicleManagement.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDto toDto(Vehicle vehicle);

    void updateFromDto(UpdateVehicleRequest dto, @MappingTarget Vehicle vehicle);
}