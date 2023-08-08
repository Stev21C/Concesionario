package com.projectcoches.ProjectConcesionarioCoches.domain.useCase;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseBillResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseUseCase {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}