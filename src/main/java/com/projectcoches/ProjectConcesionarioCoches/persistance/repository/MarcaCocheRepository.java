package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.pojo.MarcaCochePojo;
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
        return iMarcaCocheMapper.toMarcasCochePojo(iMarcaCocheCRUDRepository.findAll()); // Invoco a mapper para traer pojo
    }

    @Override
    public Optional<MarcaCochePojo> getMarcaCoche(Integer id) {
        return iMarcaCocheCRUDRepository.findById(id)
                .map(iMarcaCocheMapper::toMarcaCochePojo);  // Con metodo por referencia
                // con Lambda .map(marcaCocheEntity -> iMarcaCocheMapper.toMarcaCochePojo(marcaCocheEntity));  // No vamos por entidad, por ende vamos por optional
    }

    @Override
    public MarcaCochePojo save(MarcaCochePojo newMarcaCoche) {
        MarcaCocheEntity marcaCocheEntity= iMarcaCocheMapper.toMarcaCocheEntity(newMarcaCoche);
        return iMarcaCocheMapper.toMarcaCochePojo(iMarcaCocheCRUDRepository.save(marcaCocheEntity));
    }

    @Override
    public void delete(Integer idMarcaCoche) {
        iMarcaCocheCRUDRepository.deleteById(idMarcaCoche);
    }
}
