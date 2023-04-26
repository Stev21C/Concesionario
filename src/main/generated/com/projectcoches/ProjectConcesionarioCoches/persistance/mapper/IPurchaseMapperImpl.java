package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarPurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarPurchaseEntity;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T17:40:07-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IPurchaseMapperImpl implements IPurchaseMapper {

    @Override
    public PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity) {
        if ( purchaseEntity == null ) {
            return null;
        }

        PurchaseRequestDto purchaseRequestDto = new PurchaseRequestDto();

        purchaseRequestDto.setNumberBill( purchaseEntity.getNumberBill() );
        purchaseRequestDto.setCardIdCustomer( purchaseEntity.getCardIdCustomer() );
        purchaseRequestDto.setDate( purchaseEntity.getDate() );
        purchaseRequestDto.setTotal( purchaseEntity.getTotal() );
        purchaseRequestDto.setPaymentMethod( purchaseEntity.getPaymentMethod() );
        purchaseRequestDto.setCarsPurchase( carPurchaseEntityListToCarPurchaseRequestDtoList( purchaseEntity.getCarsPurchase() ) );

        return purchaseRequestDto;
    }

    @Override
    public PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto) {
        if ( purchaseRequestDto == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setNumberBill( purchaseRequestDto.getNumberBill() );
        purchaseEntity.setCardIdCustomer( purchaseRequestDto.getCardIdCustomer() );
        purchaseEntity.setDate( purchaseRequestDto.getDate() );
        purchaseEntity.setTotal( purchaseRequestDto.getTotal() );
        purchaseEntity.setPaymentMethod( purchaseRequestDto.getPaymentMethod() );
        purchaseEntity.setCarsPurchase( carPurchaseRequestDtoListToCarPurchaseEntityList( purchaseRequestDto.getCarsPurchase() ) );

        return purchaseEntity;
    }

    @Override
    public List<PurchaseRequestDto> toPurchaseRequestDto(List<PurchaseEntity> purchaseEntityList) {
        if ( purchaseEntityList == null ) {
            return null;
        }

        List<PurchaseRequestDto> list = new ArrayList<PurchaseRequestDto>( purchaseEntityList.size() );
        for ( PurchaseEntity purchaseEntity : purchaseEntityList ) {
            list.add( toPurchaseRequestDto( purchaseEntity ) );
        }

        return list;
    }

    protected CarPurchaseRequestDto carPurchaseEntityToCarPurchaseRequestDto(CarPurchaseEntity carPurchaseEntity) {
        if ( carPurchaseEntity == null ) {
            return null;
        }

        CarPurchaseRequestDto carPurchaseRequestDto = new CarPurchaseRequestDto();

        carPurchaseRequestDto.setQuantityCars( carPurchaseEntity.getQuantityCars() );
        carPurchaseRequestDto.setTotalPriceCars( carPurchaseEntity.getTotalPriceCars() );

        return carPurchaseRequestDto;
    }

    protected List<CarPurchaseRequestDto> carPurchaseEntityListToCarPurchaseRequestDtoList(List<CarPurchaseEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarPurchaseRequestDto> list1 = new ArrayList<CarPurchaseRequestDto>( list.size() );
        for ( CarPurchaseEntity carPurchaseEntity : list ) {
            list1.add( carPurchaseEntityToCarPurchaseRequestDto( carPurchaseEntity ) );
        }

        return list1;
    }

    protected CarPurchaseEntity carPurchaseRequestDtoToCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchaseEntity carPurchaseEntity = new CarPurchaseEntity();

        carPurchaseEntity.setQuantityCars( carPurchaseRequestDto.getQuantityCars() );
        carPurchaseEntity.setTotalPriceCars( carPurchaseRequestDto.getTotalPriceCars() );

        return carPurchaseEntity;
    }

    protected List<CarPurchaseEntity> carPurchaseRequestDtoListToCarPurchaseEntityList(List<CarPurchaseRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CarPurchaseEntity> list1 = new ArrayList<CarPurchaseEntity>( list.size() );
        for ( CarPurchaseRequestDto carPurchaseRequestDto : list ) {
            list1.add( carPurchaseRequestDtoToCarPurchaseEntity( carPurchaseRequestDto ) );
        }

        return list1;
    }
}
