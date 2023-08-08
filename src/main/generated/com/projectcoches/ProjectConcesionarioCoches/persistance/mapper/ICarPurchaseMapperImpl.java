package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarPurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarPurchaseEntity;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarPurchasePK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-08T01:37:55-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ICarPurchaseMapperImpl implements ICarPurchaseMapper {

    @Override
    public CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchaseEntity carPurchaseEntity = new CarPurchaseEntity();

        carPurchaseEntity.setId( carPurchaseRequestDtoToCarPurchasePK( carPurchaseRequestDto ) );
        carPurchaseEntity.setQuantityCars( carPurchaseRequestDto.getQuantityCars() );
        carPurchaseEntity.setTotalPriceCars( carPurchaseRequestDto.getTotalPriceCars() );

        return carPurchaseEntity;
    }

    protected CarPurchasePK carPurchaseRequestDtoToCarPurchasePK(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchasePK carPurchasePK = new CarPurchasePK();

        carPurchasePK.setCodeCar( carPurchaseRequestDto.getCodeCar() );

        return carPurchasePK;
    }
}
