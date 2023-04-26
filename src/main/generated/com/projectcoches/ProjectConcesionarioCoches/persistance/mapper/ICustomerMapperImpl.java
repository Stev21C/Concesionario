package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-25T17:40:07-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public CustomerDto toCustomerDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCardId( customerEntity.getCardId() );
        customerDto.setFullname( customerEntity.getFullname() );
        customerDto.setEmail( customerEntity.getEmail() );
        customerDto.setCellphoneNumber( customerEntity.getCellphoneNumber() );
        customerDto.setActive( customerEntity.getActive() );
        customerDto.setPassword( customerEntity.getPassword() );
        customerDto.setRol( customerEntity.getRol() );

        return customerDto;
    }

    @Override
    public CustomerEntity toCustomerEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCardId( customerDto.getCardId() );
        customerEntity.setFullname( customerDto.getFullname() );
        customerEntity.setEmail( customerDto.getEmail() );
        customerEntity.setCellphoneNumber( customerDto.getCellphoneNumber() );
        customerEntity.setActive( customerDto.getActive() );
        customerEntity.setPassword( customerDto.getPassword() );
        customerEntity.setRol( customerDto.getRol() );

        return customerEntity;
    }

    @Override
    public List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList) {
        if ( customerEntityList == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customerEntityList.size() );
        for ( CustomerEntity customerEntity : customerEntityList ) {
            list.add( toCustomerDto( customerEntity ) );
        }

        return list;
    }
}
