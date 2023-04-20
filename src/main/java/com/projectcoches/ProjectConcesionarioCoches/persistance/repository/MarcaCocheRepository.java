package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.IMarcaCocheRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.MarcaCocheEntity;
import com.projectcoches.ProjectConcesionarioCoches.persistance.mapper.IMarcaCocheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositorio de marca coche
 */

@RequiredArgsConstructor  // Crea constructor, Toma los de final
@Repository
public class MarcaCocheRepository implements IMarcaCocheRepository {

    // Se podria colocar @Autowired pero se debe colocar constructor

    /**
     * CRUD Marca ciche
     */
    private final IMarcaCocheCRUDRepository iMarcaCocheCRUDRepository;

    /**
     * Mapper marca coche
     */
    private final IMarcaCocheMapper iMarcaCocheMapper;

    /* Se puede omitir el constructor colocando @RequiredArgsConstructor o @AllArgsConstructor(no recomendado)
    public MarcaCocheRepository(IMarcaCocheCRUDRepository iMarcaCocheCRUDRepository, IMarcaCocheMapper iMarcaCocheMapper) {
        this.iMarcaCocheCRUDRepository = iMarcaCocheCRUDRepository;
        this.iMarcaCocheMapper = iMarcaCocheMapper;
    }*/

    @Override
    public List<MarcaCochePojo> getAll() {
        return iMarcaCocheMapper.toMarcasCocheDto(iMarcaCocheCRUDRepository.findAll()); // Invoco a mapper para traer pojo
    }

    @Override
    public Optional<MarcaCochePojo> getMarcaCoche(Integer id) {
        return iMarcaCocheCRUDRepository.findById(id)
                .map(iMarcaCocheMapper::toMarcaCocheDto);  // Con metodo por referencia, de mapper llame al pojo
                // con Lambda .map(marcaCocheEntity -> iMarcaCocheMapper.toMarcaCocheDto(marcaCocheEntity));  // No vamos por entidad, por ende vamos por optional
    }

    @Override
    public MarcaCochePojo save(MarcaCochePojo newMarcaCoche) {   // Recibo mi pojo nuevo
        MarcaCocheEntity marcaCocheEntity= iMarcaCocheMapper.toMarcaCocheEntity(newMarcaCoche); // con mapper la transformo a entidad
        return iMarcaCocheMapper.toMarcaCocheDto(iMarcaCocheCRUDRepository.save(marcaCocheEntity)); // la entidad la guardo, la convierto a pojo y la devuelvo
    }

    @Override
    public void delete(Integer idMarcaCoche) {
        iMarcaCocheCRUDRepository.deleteById(idMarcaCoche);
    }
}
