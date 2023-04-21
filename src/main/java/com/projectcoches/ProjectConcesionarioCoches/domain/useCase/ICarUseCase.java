package com.projectcoches.ProjectConcesionarioCoches.domain.useCase;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

// Al final es mas una interfaz de casos de uso
public interface ICarUseCase {

    List<CarDto> getAll();

    List<CarDto> getByIdMarcaCoche(Integer idMarcaCoche);

    List<CarDto> getByPriceLessThan(Double price); // Retorna los carros menores a un precio double que paso

    Optional<CarDto> getCar(Integer idCar);  // Impide el nullpointerException, al no encontrar id

    CarDto save(CarDto newCoche);

    boolean delete(Integer idCar);
}
