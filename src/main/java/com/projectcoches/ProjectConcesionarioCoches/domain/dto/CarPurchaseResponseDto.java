package com.projectcoches.ProjectConcesionarioCoches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de la consulta de los carros de una compra
 */
@Getter
@Setter
public class CarPurchaseResponseDto {

    private String referenceCar;  // Se guardara la referencia del carro

    private Integer quantityCars;

    private Integer totalPriceCars; // total de todos los carros que compraron

    //private Double valorUnitario= (double) (totalPriceCars/quantityCars);
}
