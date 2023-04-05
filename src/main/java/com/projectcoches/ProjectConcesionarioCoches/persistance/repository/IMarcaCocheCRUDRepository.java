package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.MarcaCocheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaCocheCRUDRepository extends JpaRepository<MarcaCocheEntity, Integer> {  // Contiene CRUDRepository

    // No hay que escribir los metodos de save, delete, update, search(SELECT *)


}
