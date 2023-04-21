package com.projectcoches.ProjectConcesionarioCoches.domain.service;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.ICarRepository;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService implements ICarUseCase {

    private final ICarRepository iCarRepository;

    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdMarcaCoche(Integer idMarcaCoche) {
        return iCarRepository.getByIdMarcaCoche(idMarcaCoche);
    }

    @Override
    public List<CarDto> getByPriceLessThan(Double price) {
        return iCarRepository.getByPriceLessThan(price);
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarRepository.getCar(idCar);
    }

    @Override
    public CarDto save(CarDto newCoche) {
        return iCarRepository.save(newCoche);
    }

    @Override
    public boolean delete(Integer idCar) {
        if(iCarRepository.getCar(idCar).isEmpty()){ // Si la marca existe editela, sino esta vacio y retorne nulo
            return false;                                   // Se usa para no tener Nulos y queda mas limpio
        }

        iCarRepository.delete(idCar);
        return true;
    }
}
