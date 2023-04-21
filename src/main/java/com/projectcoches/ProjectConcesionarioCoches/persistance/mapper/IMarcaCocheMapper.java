package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de marca_coche a pojos o entidades
 */

@Mapper(componentModel = "spring")  // de mapstruct, componente de spring, para inyectar la intr, mapear entre entidades a pojos
public interface IMarcaCocheMapper {

    /**
     *  Convierte entidad MarcaCoche a pojo MarcaCoche
     * @param marcaEntity Entidad a convertir
     * @return pojo convertido
     */

    //Son opcionales los mapping
    @Mapping(source = "id", target = "id")  // source entidad origen
    @Mapping(source = "descripcion", target = "descripcion") // Target entidad destino

    MarcaCochePojo toMarcaCocheDto(MarcaCocheEntity marcaEntity);  // Recibo entity y transformo a pojo

    /**
     * Convierte un pojo a una entidad marca coche
     * @param marcaPojo pojo a convertir
     * @return entity convertido
     */
    @InheritInverseConfiguration    // Toma loa mapping o ajustes e inviertalos
    @Mapping(target = "carEntities", ignore = true) // Ignora la relacion
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo);

    /**
     * Retorna una lista de marcas coche, trnasformada a pojo
     * de una lista de entidades
     * @param marcasCocheEntity entidad a transformar
     * @return Lista transformada
     */
    List<MarcaCochePojo> toMarcasCocheDto(List<MarcaCocheEntity> marcasCocheEntity);

}
