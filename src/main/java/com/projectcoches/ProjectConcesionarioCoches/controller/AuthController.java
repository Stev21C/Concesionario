package com.projectcoches.ProjectConcesionarioCoches.controller;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.AuthCustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.JwtResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.ResponsePassCustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.IAuthUseCase;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final IAuthUseCase iAuthUseCase;

    private final ICustomerUseCase iCustomerUseCase;

    @PostMapping(path = "/register")
    public ResponseEntity<ResponsePassCustomerDto> save(@RequestBody CustomerDto customerDtoNew){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerUseCase.save(customerDtoNew));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
