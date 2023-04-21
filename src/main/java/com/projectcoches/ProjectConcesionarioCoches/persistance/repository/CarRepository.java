package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.ICarRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.crud.ICarCRUDRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository{

    private final ICarCRUDRepository iCarCRUDRepository;

    private final ICarMapper iCarMapper;

    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarCRUDRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdMarcaCoche(Integer idMarcaCoche) {
        return iCarMapper.toCarsDto(iCarCRUDRepository.findAllByMarcaCocheId(idMarcaCoche));
    }

    @Override
    public List<CarDto> getByPriceLessThan(Double price) {
        return iCarMapper.toCarsDto(iCarCRUDRepository.findAllByPriceLessThanOrderByPriceAsc(price));
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarCRUDRepository.findById(idCar)
                .map(iCarMapper::toCarDto);
    }

    @Override
    public CarDto save(CarDto newCoche) {
        return iCarMapper.toCarDto(iCarCRUDRepository.save(iCarMapper.toCarEntity(newCoche))); // la entidad la guardo, la convierto a pojo y la devuelvo
    }

    @Override
    public void delete(Integer idCar) {
        iCarCRUDRepository.deleteById(idCar);
    }
}
