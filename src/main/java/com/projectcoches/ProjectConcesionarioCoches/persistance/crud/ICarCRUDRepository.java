package com.projectcoches.ProjectConcesionarioCoches.persistance.crud;

import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCRUDRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByMarcaCocheId(Integer id);

    List<CarEntity> findAllByPriceLessThanOrderByPriceAsc(Double price);
}
