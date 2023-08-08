package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarPurchaseResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseBillResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseRequestDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.PurchaseResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.IPurchaseRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.crud.IPurchaseCrudRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.PurchaseEntity;
import com.projectcoches.ProjectConcesionarioCoches.persistance.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseCrudRepository iPurchaseCrudRepository;

    private final IPurchaseMapper iPurchaseMapper;

    @Override
    public List<PurchaseResponseDto> getAll() {
        List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAll();
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAllByCardIdCustomer(idCustomer);
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        Optional<PurchaseEntity> purchaseEntitySearch = iPurchaseCrudRepository.findById(numberBill);

        if(purchaseEntitySearch.isEmpty()) {
            return null;
        }

        return toPurchaseResponseDtoByEntity(purchaseEntitySearch.get());
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseEntity purchaseEntity = iPurchaseMapper.toPurchaseEntity(purchaseRequestDto);

        purchaseEntity.getCarsPurchase().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity)); // Se toma el carro de la compra y se cambia la compra a la que esta atado, todos los carros se relacionan a la compra

        PurchaseEntity purchaseEntitySave = iPurchaseCrudRepository.save(purchaseEntity); // Guarda la compra
        return new PurchaseBillResponseDto(purchaseEntitySave.getNumberBill());
    }


    public PurchaseResponseDto toPurchaseResponseDtoByEntity(PurchaseEntity purchaseEntity) {
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setNumberBill(purchaseEntity.getNumberBill());
        purchaseResponseDto.setCardIdCustomer(purchaseEntity.getCardIdCustomer());
        purchaseResponseDto.setDate(purchaseEntity.getDate());
        purchaseResponseDto.setTotal(purchaseEntity.getTotal());
        purchaseResponseDto.setPaymentMethod(purchaseEntity.getPaymentMethod());

        List<CarPurchaseResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        purchaseEntity.getCarsPurchase().forEach(carPurchaseEntity -> {  // Hay que sacar los valores de CarPurchaseEntity
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantityCars();
            Integer total = carPurchaseEntity.getTotalPriceCars();
            carPurchaseResponseDtoList.add(new CarPurchaseResponseDto(reference, quantity, total));
        });

        purchaseResponseDto.setCarsPurchase(carPurchaseResponseDtoList);

        return purchaseResponseDto;
    }
}
