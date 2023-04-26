package com.projectcoches.ProjectConcesionarioCoches.domain.service;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.AuthCustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.JwtResponseDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.ICustomerRepository;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.IAuthUseCase;
import com.projectcoches.ProjectConcesionarioCoches.exception.CustomerNotExistException;
import com.projectcoches.ProjectConcesionarioCoches.exception.PasswordIncorrectException;
import com.projectcoches.ProjectConcesionarioCoches.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio encargado del logueo de un usuario
 */
@RequiredArgsConstructor
@Service
public class AuthService implements IAuthUseCase {

    private final ICustomerRepository iCustomerRepository;

    /**
     * Clase que administra los JWTs
     */
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Clase que encripta contraseñas
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Devuelve un dto con el jwt del usuario dadas unas credenciales
     * @param authCustomerDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) {

        Optional<CustomerDto> customer = iCustomerRepository.getCustomerByEmail(authCustomerDto.getEmail());

        if (customer.isEmpty()) {
            throw new CustomerNotExistException();
        }

        if (!passwordEncoder.matches(authCustomerDto.getPassword(), customer.get().getPassword())) {
            throw new PasswordIncorrectException();
        }


        return new JwtResponseDto(jwtAuthenticationProvider.createToken(customer.get()));
    }

    /**
     * Cierra la sesión eliminando de la lista blanca el token ingresado
     * @param token Token a eliminar
     * @return
     */
    public JwtResponseDto signOut(String token) {

        String[] authElements = token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));
    }

}