package com.projectcoches.ProjectConcesionarioCoches.domain.service;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseBillResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.ICarRepository;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.IPurchaseRepository;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.IPurchaseUseCase;
import com.projectcoches.ProjectConcesionarioCoches.exception.PurchaseNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PurchaseService implements IPurchaseUseCase {

    private final IPurchaseRepository iPurchaseRepository;

    private final ICarRepository iCarRepository;

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
        PurchaseBillResponseDto billResponseDto = iPurchaseRepository.save(purchaseRequestDto);

        /**
         * Se toma la cantidad de stock y se le resto lo que se indico en el purchase o factura
         */
        purchaseRequestDto.getCarsPurchase().forEach(carPurchase -> {
            CarDto carActual = iCarRepository.getCar(carPurchase.getCodeCar()).get();

            carActual.setStock(carActual.getStock() - carPurchase.getQuantityCars());

            iCarRepository.save(carActual);
        });

        return billResponseDto;
    }
}