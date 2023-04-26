package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.IPurchaseRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.crud.IPurchaseCrudRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseCrudRepository iPurchaseCrudRepository;

    private final IPurchaseMapper iPurchaseMapper;

    @Override
    public List<PurchaseResponseDto> getAll() {
        return null;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return null;
    }

    @Override
    public PurchaseResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        return null;
    }
}
