package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCRUDRepository extends JpaRepository<CustomerEntity, String> {

    //Query method, ahorra escribir el (Select)
    Optional<CustomerEntity> findByEmail(String email);
}
