package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    CarDto toCarDto(CarEntity carEntity);

    @Mapping(target = "marcaCocheEntity", ignore = true) // Ignora la relacion
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarsDto(List<CarEntity> carEntityList);
}
