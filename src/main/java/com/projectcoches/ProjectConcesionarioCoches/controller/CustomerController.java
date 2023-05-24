package com.projectcoches.ProjectConcesionarioCoches.controller;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.ResponsePassCustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping()      // El metodo va a estar manupulado por metodo GET http, para consultas
    public ResponseEntity<List<CustomerDto>> getAll(){   // Retorna lista de Pojos
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId){
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(cardId));
    }

    @GetMapping(path = "/emails/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate){
        return ResponseEntity.of(iCustomerUseCase.update(customerDtoUpdate));
    }

    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId){
        return new ResponseEntity<>(this.iCustomerUseCase.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
