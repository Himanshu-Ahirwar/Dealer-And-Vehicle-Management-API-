package com.example.DealerAndVechicleManagement.mapper;

import com.example.DealerAndVechicleManagement.dto.UpdateVehicleRequest;
import com.example.DealerAndVechicleManagement.dto.VehicleDto;
import com.example.DealerAndVechicleManagement.model.Vehicle;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-18T22:35:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public VehicleDto toDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId( vehicle.getId() );
        vehicleDto.setModel( vehicle.getModel() );
        vehicleDto.setPrice( vehicle.getPrice() );
        if ( vehicle.getStatus() != null ) {
            vehicleDto.setStatus( vehicle.getStatus().name() );
        }

        return vehicleDto;
    }

    @Override
    public void updateFromDto(UpdateVehicleRequest dto, Vehicle vehicle) {
        if ( dto == null ) {
            return;
        }

        vehicle.setModel( dto.getModel() );
        vehicle.setPrice( dto.getPrice() );
        vehicle.setStatus( dto.getStatus() );
    }
}
