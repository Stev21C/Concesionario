package com.projectcoches.ProjectConcesionarioCoches.persistance.repository;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.ICustomerRepository;
import com.projectcoches.ProjectConcesionarioCoches.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {


    private final ICustomerCRUDRepository iCustomerCRUDRepository;

    private final ICustomerMapper iCustomerMapper;



    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerCRUDRepository.findAll()); // Invoco a mapper para traer pojo
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerCRUDRepository.findById(cardId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCRUDRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        return iCustomerMapper.toCustomerDto(iCustomerCRUDRepository.save(iCustomerMapper.toCustomerEntity(newCustomer))); // la entidad la guardo, la convierto a pojo y la devuelvo
    }

    @Override
    public void delete(String cardId) {
        iCustomerCRUDRepository.deleteById(cardId);
    }
}
