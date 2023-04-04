package com.projectcoches.ProjectConcesionarioCoches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/** Documentacion:
 *  Pojo de marca_coche
 */

@Getter
@Setter
//Data es mala practica usar, genera problemas al hacer test
public class MarcaCochePojo {

    /**
     * Id de la marca
     */
    private Integer id;

    /**
     * Descripcion de la marca
     */
    private String description;
}