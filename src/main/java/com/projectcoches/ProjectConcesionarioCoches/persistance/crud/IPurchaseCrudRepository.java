package com.projectcoches.ProjectConcesionarioCoches.persistance.crud;



import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPurchaseCrudRepository extends JpaRepository<PurchaseEntity, Integer> {

}