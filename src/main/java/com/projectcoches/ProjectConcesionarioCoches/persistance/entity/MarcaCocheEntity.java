package com.projectcoches.ProjectConcesionarioCoches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad de marca_coche
 */

@Getter
@Setter
@Entity    // Indicar que es entidad
@Table(name= "marca_coche") // Poner nombre de la tabla de la DB
public class MarcaCocheEntity {

    /**
     * Id de la marca_coche
     */
    @Id
    //@Column(name= "id") sse coloca si tuviera != nombre en DB y el atributo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "descripcion") // Opcional
    private String descripcion;

    @OneToMany(mappedBy = "marcaCocheEntity", orphanRemoval = true)
    private List<CarEntity> carEntities = new ArrayList<>();

}
