package com.example.DealerAndVechicleManagement.mapper;

import com.example.DealerAndVechicleManagement.dto.CreateDealerRequest;
import com.example.DealerAndVechicleManagement.dto.DealerDto;
import com.example.DealerAndVechicleManagement.dto.UpdateDealerRequest;
import com.example.DealerAndVechicleManagement.model.Dealer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-18T22:35:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class DealerMapperImpl implements DealerMapper {

    @Override
    public DealerDto toDto(Dealer dealer) {
        if ( dealer == null ) {
            return null;
        }

        DealerDto dealerDto = new DealerDto();

        dealerDto.setId( dealer.getId() );
        dealerDto.setName( dealer.getName() );
        dealerDto.setEmail( dealer.getEmail() );
        if ( dealer.getSubscriptionType() != null ) {
            dealerDto.setSubscriptionType( dealer.getSubscriptionType().name() );
        }

        return dealerDto;
    }

    @Override
    public Dealer toEntity(CreateDealerRequest request) {
        if ( request == null ) {
            return null;
        }

        Dealer dealer = new Dealer();

        dealer.setName( request.getName() );
        dealer.setEmail( request.getEmail() );
        if ( request.getSubscriptionType() != null ) {
            dealer.setSubscriptionType( Enum.valueOf( SubscriptionType.class, request.getSubscriptionType() ) );
        }

        return dealer;
    }

    @Override
    public void updateFromDto(UpdateDealerRequest dto, Dealer dealer) {
        if ( dto == null ) {
            return;
        }

        dealer.setName( dto.getName() );
        dealer.setEmail( dto.getEmail() );
        if ( dto.getSubscriptionType() != null ) {
            dealer.setSubscriptionType( Enum.valueOf( SubscriptionType.class, dto.getSubscriptionType() ) );
        }
        else {
            dealer.setSubscriptionType( null );
        }
    }
}
