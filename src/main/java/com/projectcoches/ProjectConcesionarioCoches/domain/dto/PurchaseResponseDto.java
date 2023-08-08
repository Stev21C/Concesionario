package com.projectcoches.ProjectConcesionarioCoches.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  Dto de la consulta de una compra
 */
@Getter
@Setter
public class PurchaseResponseDto {

    private Integer numberBill;

    private String cardIdCustomer;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<CarPurchaseResponseDto> carsPurchase;  // Son los carros de la compra
}
