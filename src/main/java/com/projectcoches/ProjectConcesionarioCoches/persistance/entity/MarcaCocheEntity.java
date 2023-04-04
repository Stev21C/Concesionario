package com.projectcoches.ProjectConcesionarioCoches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de marca_coche
 */

@Getter
@Setter
@Entity    // Indicar que es entidad
@Table(name= "marca_coche") // Poner nombre de la tabla de la DB
public class MarcaCocheEntity {

    @Id
    //@Column(name= "id") sse coloca si tuviera != nombre en DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "descripcion") // Opcional
    private String description;


}
