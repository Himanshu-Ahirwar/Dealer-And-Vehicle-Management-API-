package com.example.DealerAndVechicleManagement.mapper;

import com.example.DealerAndVechicleManagement.dto.CreateDealerRequest;
import com.example.DealerAndVechicleManagement.dto.DealerDto;
import com.example.DealerAndVechicleManagement.dto.UpdateDealerRequest;
import com.example.DealerAndVechicleManagement.model.Dealer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DealerMapper {


    DealerDto toDto(Dealer dealer);

    Dealer toEntity(CreateDealerRequest request);

    void updateFromDto(UpdateDealerRequest dto, @MappingTarget Dealer dealer);
}