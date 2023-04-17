package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.pojo.MarcaCochePojo;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.MarcaCocheEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T00:09:46-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IMarcaCocheMapperImpl implements IMarcaCocheMapper {

    @Override
    public MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        MarcaCochePojo marcaCochePojo = new MarcaCochePojo();

        marcaCochePojo.setId( marcaEntity.getId() );
        marcaCochePojo.setDescription( marcaEntity.getDescription() );

        return marcaCochePojo;
    }

    @Override
    public MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo) {
        if ( marcaPojo == null ) {
            return null;
        }

        MarcaCocheEntity marcaCocheEntity = new MarcaCocheEntity();

        marcaCocheEntity.setId( marcaPojo.getId() );
        marcaCocheEntity.setDescription( marcaPojo.getDescription() );

        return marcaCocheEntity;
    }

    @Override
    public List<MarcaCochePojo> toMarcasCochePojo(List<MarcaCocheEntity> marcasCocheEntity) {
        if ( marcasCocheEntity == null ) {
            return null;
        }

        List<MarcaCochePojo> list = new ArrayList<MarcaCochePojo>( marcasCocheEntity.size() );
        for ( MarcaCocheEntity marcaCocheEntity : marcasCocheEntity ) {
            list.add( toMarcaCochePojo( marcaCocheEntity ) );
        }

        return list;
    }
}
