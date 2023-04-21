package com.projectcoches.ProjectConcesionarioCoches.domain.useCase;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.ResponsePassCustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerUseCase {

    /**
     * Devuelve lista  con todos los clientes
     * @return lista con clientes
     */
    List<CustomerDto> getAll();


    Optional<CustomerDto> getCustomerByCardId(String cardId);  // Impide el nullpointerException, al no encontrar id

    Optional<CustomerDto> getCustomerByEmail(String email);

    ResponsePassCustomerDto save(CustomerDto newCustomer);

    Optional<CustomerDto> update(CustomerDto modifyCustomer);

    boolean delete(String cardId);
}
