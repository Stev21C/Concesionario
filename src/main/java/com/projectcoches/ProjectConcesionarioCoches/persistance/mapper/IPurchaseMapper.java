package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mappper de compras
 */

@Mapper(componentModel = "spring", uses = {ICarPurchaseMapper.class})
public interface IPurchaseMapper {

    //Borrar PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto); // Como mapear los obj de adentro, porque tiene lista de carros

    //Borrar List<PurchaseRequestDto> toPurchaseRequestDto(List<PurchaseEntity> purchaseEntityList);
}
