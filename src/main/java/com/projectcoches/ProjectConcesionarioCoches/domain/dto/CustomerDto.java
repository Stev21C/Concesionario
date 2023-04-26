package com.projectcoches.ProjectConcesionarioCoches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    // Se declaran Variables de la entidad de DB
    private String cardId;

    private String fullname;

    private String email;

    private Double cellphoneNumber;

    private Integer active;

    private String password;

    private String rol;
}
