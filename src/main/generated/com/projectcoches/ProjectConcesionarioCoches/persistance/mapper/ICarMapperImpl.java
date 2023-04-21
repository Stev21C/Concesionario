package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CarDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T00:14:06-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ICarMapperImpl implements ICarMapper {

    @Override
    public CarDto toCarDto(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setCodeCar( carEntity.getCodeCar() );
        carDto.setMarcaCocheId( carEntity.getMarcaCocheId() );
        carDto.setReference( carEntity.getReference() );
        carDto.setPrice( carEntity.getPrice() );
        carDto.setModelYear( carEntity.getModelYear() );
        carDto.setColor( carEntity.getColor() );
        carDto.setHorsePower( carEntity.getHorsePower() );
        carDto.setNumberDoor( carEntity.getNumberDoor() );
        carDto.setEngineDisplacement( carEntity.getEngineDisplacement() );
        carDto.setTransmission( carEntity.getTransmission() );
        carDto.setFuelType( carEntity.getFuelType() );
        carDto.setTraction( carEntity.getTraction() );
        carDto.setNumberSeats( carEntity.getNumberSeats() );
        carDto.setSteering( carEntity.getSteering() );
        carDto.setCategory( carEntity.getCategory() );
        carDto.setImagePath( carEntity.getImagePath() );

        return carDto;
    }

    @Override
    public CarEntity toCarEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setCodeCar( carDto.getCodeCar() );
        carEntity.setMarcaCocheId( carDto.getMarcaCocheId() );
        carEntity.setReference( carDto.getReference() );
        carEntity.setPrice( carDto.getPrice() );
        carEntity.setModelYear( carDto.getModelYear() );
        carEntity.setColor( carDto.getColor() );
        carEntity.setHorsePower( carDto.getHorsePower() );
        carEntity.setNumberDoor( carDto.getNumberDoor() );
        carEntity.setEngineDisplacement( carDto.getEngineDisplacement() );
        carEntity.setTransmission( carDto.getTransmission() );
        carEntity.setFuelType( carDto.getFuelType() );
        carEntity.setTraction( carDto.getTraction() );
        carEntity.setNumberSeats( carDto.getNumberSeats() );
        carEntity.setSteering( carDto.getSteering() );
        carEntity.setCategory( carDto.getCategory() );
        carEntity.setImagePath( carDto.getImagePath() );

        return carEntity;
    }

    @Override
    public List<CarDto> toCarsDto(List<CarEntity> carEntityList) {
        if ( carEntityList == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( carEntityList.size() );
        for ( CarEntity carEntity : carEntityList ) {
            list.add( toCarDto( carEntity ) );
        }

        return list;
    }
}
