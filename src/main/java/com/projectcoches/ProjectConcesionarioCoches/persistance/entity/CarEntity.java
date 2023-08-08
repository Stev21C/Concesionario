package com.projectcoches.ProjectConcesionarioCoches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "coches")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche", nullable = false)
    private Integer codeCar;

    @Column(name = "marca_coche_id")
    private Integer marcaCocheId;

    @Column(name = "referencia")
    private String reference;

    @Column(name = "precio")
    private Integer price;

    @Column(name = "anio_modelo")
    private Integer modelYear;

    @Column(name = "color")
    private String color;

    @Column(name = "numero_caballos_fuerza")
    private Integer horsePower;

    @Column(name = "cantidad_puertas")
    private Double numberDoor;

    @Column(name = "cilindraje")
    private Double engineDisplacement;

    @Column(name = "transmision")
    private String transmission;

    @Column(name = "tipo_combustible")
    private String fuelType;

    @Column(name = "traccion")
    private Integer traction;

    @Column(name = "cantidad_asientos")
    private Double numberSeats;

    @Column(name = "direccion")
    private String steering;

    @Column(name = "categoria")
    private String category;

    @Column(name = "ruta_imagen")
    private String imagePath;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)  //No se inserta ni se actualiza.
    private MarcaCocheEntity marcaCocheEntity;

    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntity;

}
