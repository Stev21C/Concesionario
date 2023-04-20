package com.projectcoches.ProjectConcesionarioCoches.domain.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.MarcaCochePojo;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheRepository {


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
    Optional<MarcaCochePojo> getMarcaCoche(Integer id);  // Impide el nullpointerException, al no encontrar id


    /**
     * Guarda una nueva marca coche, sirve para actualizar o update
     * @param newMarcaCoche Marca coche a guardar
     * @return  Marca coche guardada
     */
    MarcaCochePojo save(MarcaCochePojo newMarcaCoche);

    /**
     * Elimina una marca coche dada su ID
     * @param idMarcaCoche id marca coche a eliminar
     */
    void delete(Integer idMarcaCoche);
}
