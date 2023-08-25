package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarPurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarPurchaseEntity;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-25T00:19:43-0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.0.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IPurchaseMapperImpl implements IPurchaseMapper {

    @Autowired
    private ICarPurchaseMapper iCarPurchaseMapper;

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

    protected List<CarPurchaseEntity> carPurchaseRequestDtoListToCarPurchaseEntityList(List<CarPurchaseRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CarPurchaseEntity> list1 = new ArrayList<CarPurchaseEntity>( list.size() );
        for ( CarPurchaseRequestDto carPurchaseRequestDto : list ) {
            list1.add( iCarPurchaseMapper.toCarPurchaseEntity( carPurchaseRequestDto ) );
        }

        return list1;
    }
}
