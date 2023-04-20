package com.projectcoches.ProjectConcesionarioCoches.domain.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    /**
     * Devuelve lista  con todos los clientes
     * @return lista con clientes
     */
    List<CustomerDto> getAll();


    Optional<CustomerDto> getCustomerByCardId(String cardId);  // Impide el nullpointerException, al no encontrar id

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomer);

    void delete(String cardId);
}
