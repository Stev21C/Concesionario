package com.projectcoches.ProjectConcesionarioCoches.domain.service;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseBillResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.IPurchaseRepository;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.IPurchaseUseCase;
import com.projectcoches.ProjectConcesionarioCoches.exception.PurchaseNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PurchaseService implements IPurchaseUseCase {

    private final IPurchaseRepository iPurchaseRepository;

    @Override
    public List<PurchaseResponseDto> getAll() {
        return iPurchaseRepository.getAll();
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return iPurchaseRepository.getByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        PurchaseResponseDto purchaseResponseDto = iPurchaseRepository.getByNumberBill(numberBill);

        if (purchaseResponseDto == null) {
            throw new PurchaseNotExistException();
        }

        return purchaseResponseDto;
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        return iPurchaseRepository.save(purchaseRequestDto);
    }
}