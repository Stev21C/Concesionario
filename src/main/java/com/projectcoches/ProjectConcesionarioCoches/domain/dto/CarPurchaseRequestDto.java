package com.projectcoches.ProjectConcesionarioCoches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto del guardado de los carros de una compra
 */
@Getter @Setter
public class CarPurchaseRequestDto {

    private Integer purchaseNumberBill;

    private Integer codeCar;

    private Integer quantityCars;

    private Integer totalPriceCars; // total de todos los carros que compraron
}
