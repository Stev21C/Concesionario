package com.projectcoches.ProjectConcesionarioCoches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarDto {
    private Integer codeCar;

    private Integer marcaCocheId;

    private String reference;

    private Integer price;

    private Integer modelYear;

    private String color;

    private Integer horsePower;

    private Double numberDoor;

    private Double engineDisplacement;

    private String transmission;

    private String fuelType;

    private Integer traction;

    private Double numberSeats;

    private String steering;

    private String category;

    private String imagePath;
}
