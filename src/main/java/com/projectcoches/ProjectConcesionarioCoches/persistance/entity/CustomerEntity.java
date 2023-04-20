package com.projectcoches.ProjectConcesionarioCoches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de cliente
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")  // Se declaran y se pone nombre de la DB
public class CustomerEntity {

    @Id
    @Column(name= "cedula")
    private String cardId;

    @Column(name= "nombre_completo")
    private String fullname;

    @Column(name= "correo")
    private String email;

    @Column(name= "numero_celular")
    private Double cellphoneNumber;

    @Column(name= "activo")
    private Integer active;

    @Column(name= "contrasenia")
    private String password;

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "cardId='" + cardId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", cellphoneNumber=" + cellphoneNumber +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }
}
