package com.projectcoches.ProjectConcesionarioCoches.persistance.mapper;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper cliente
 */

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);
}
