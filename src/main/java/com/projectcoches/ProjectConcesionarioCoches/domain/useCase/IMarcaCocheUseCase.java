package com.projectcoches.ProjectConcesionarioCoches.domain.useCase;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.MarcaCochePojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheUseCase {

    /**
     * Devuelve lista  con todas las marcas coches
     * @return lista con marcas de coches
     */
    List<MarcaCochePojo> getAll();


    /**
     * Devuelve una marca de coche dada su id
     * @param id  Id de la marca de coche
     * @return Optional del marca coche encontrado
     */
    Optional<MarcaCochePojo> getMarcaCoche(Integer id);  // Impide el nullpointer, al no encontrar id


    /**
     * Guarda una nueva marca coche
     * @param newMarcaCoche Marca coche a guardar
     * @return  Marca coche guardada
     */
    MarcaCochePojo save(MarcaCochePojo newMarcaCoche);


    /**
     * Actualiza marca coche
     * @param newMarcaCoche Marca coche actualizar
     * @return marca actualziada
     */
    Optional<MarcaCochePojo> update(MarcaCochePojo newMarcaCoche);


    /**
     * Elimina una marca coche dada su ID
     *
     * @param idMarcaCoche marca coche a eliminar
     * @return true si se elimino
     */
    boolean delete(Integer idMarcaCoche);

}
