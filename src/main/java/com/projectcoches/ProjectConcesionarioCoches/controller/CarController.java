package com.projectcoches.ProjectConcesionarioCoches.controller;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/coches")
public class CarController {

    private final ICarUseCase iCarUseCase;

    @GetMapping()
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    @GetMapping(path = "/marca-coche/{idMarcaCoche}")
    public ResponseEntity<List<CarDto>>getByIdMarcaCoche(@PathVariable Integer idMarcaCoche){
        return ResponseEntity.ok(iCarUseCase.getByIdMarcaCoche(idMarcaCoche));
    }

    @GetMapping(path = "/price/{priceCar}")
    public ResponseEntity<List<CarDto>>getByPriceLessThan(@PathVariable Double priceCar){
        return ResponseEntity.ok(iCarUseCase.getByPriceLessThan(priceCar));
    }

    @GetMapping(path = "/{idCar}")
    public ResponseEntity<CarDto>getCar(@PathVariable Integer idCar){
        return ResponseEntity.of(iCarUseCase.getCar(idCar));
    }

    @PostMapping
    public ResponseEntity<CarDto>save(@RequestBody CarDto carDtoNew){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarUseCase.save(carDtoNew));

    }

    @DeleteMapping(path = "/{idCar}")
    public ResponseEntity<Boolean>delete(@PathVariable Integer idCar){
        return new ResponseEntity<>(this.iCarUseCase.delete(idCar) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
