package com.projectcoches.ProjectConcesionarioCoches.domain.service;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.IMarcaCocheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *  Servicio de marca coche
 *  Va la logica de negocio, que un campo deba tener 5 caracteres u otras validaciones
 */
@RequiredArgsConstructor
@Service
public class MarcaCocheService implements IMarcaCocheService {

    /**
     * Repository de marca coche
     */
    private final IMarcaCocheRepository iMarcaCocheRepository;

    /**
     * Devuelve lista con todas las marcas coches
     * @return Lista marcas coches
     */
    @Override
    public List<MarcaCochePojo> getAll() {
        return iMarcaCocheRepository.getAll();
    }

    /**
     * Devuelve marca coche dada du id
     * @param id  Id de la marca de coche
     * @return optional del marca coche encontrado
     */
    @Override
    public Optional<MarcaCochePojo> getMarcaCoche(Integer id) {
        return iMarcaCocheRepository.getMarcaCoche(id);
    }

    /**
     * Guarda una nueva marca coche
     * @param newMarcaCoche Marca coche a guardar
     * @return marca coche guardada
     */
    @Override
    public MarcaCochePojo save(MarcaCochePojo newMarcaCoche) {
        return iMarcaCocheRepository.save(newMarcaCoche);
    }


    /**
     * Actualiza una marca coche opcional
     * @param newMarcaCoche Marca coche actualizar
     * @return Optional Marca coche actualizada
     */
    @Override
    public Optional<MarcaCochePojo> update(MarcaCochePojo newMarcaCoche) {
        if(iMarcaCocheRepository.getMarcaCoche(newMarcaCoche.getId()).isEmpty()){ // Si la marca existe editela, sino esta vacio y retorne nulo
            return Optional.empty();                                             // Se usa para no tener Nulos y queda mas limpio
        }
        return Optional.of(iMarcaCocheRepository.save(newMarcaCoche));
    }


    /**
     * Elimina marca coche dada su id
     * @param idMarcaCoche marca coche a eliminar
     * @return true si elimino
     */
    @Override
    public boolean delete(Integer idMarcaCoche) {
        if(iMarcaCocheRepository.getMarcaCoche(idMarcaCoche).isEmpty()){ // Si la marca existe editela, sino esta vacio y retorne nulo
            return false;                                   // Se usa para no tener Nulos y queda mas limpio
        }

        // Colocar else seria redundar
        iMarcaCocheRepository.delete(idMarcaCoche);
        return true;

    }
}
