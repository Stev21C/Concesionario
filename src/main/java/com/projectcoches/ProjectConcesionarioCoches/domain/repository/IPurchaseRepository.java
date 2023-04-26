package com.projectcoches.ProjectConcesionarioCoches.domain.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseRepository {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
