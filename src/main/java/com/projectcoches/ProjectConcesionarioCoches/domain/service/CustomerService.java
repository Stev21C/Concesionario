package com.projectcoches.ProjectConcesionarioCoches.domain.service;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.CustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.ResponsePassCustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.repository.ICustomerRepository;
import com.projectcoches.ProjectConcesionarioCoches.domain.useCase.ICustomerUseCase;
import com.projectcoches.ProjectConcesionarioCoches.exception.CustomerNotExistException;
import com.projectcoches.ProjectConcesionarioCoches.exception.EmailValidationException;
import com.projectcoches.ProjectConcesionarioCoches.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {


    private final ICustomerRepository iCustomerRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponsePassCustomerDto save(CustomerDto newCustomer) {

        if(!newCustomer.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"   // Expresiones regulares
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new EmailValidationException();
        }

        /**
         * Validacion para no ingresar usuario que ya tiene correo o usuario registrado
         */
        if(getCustomerByCardId(newCustomer.getCardId()).isPresent() || getCustomerByEmail(newCustomer.getEmail()).isPresent()){
            throw new CustomerNotExistException();
        }


        /**
         * Contraseña generada aleatoria desde backend
         */
        String passwordGenerated= generateRandomPassword(8);
        newCustomer.setPassword(passwordEncoder.encode(passwordGenerated)); //se encripta la clave
        newCustomer.setActive(1);
        newCustomer.setRol(Roles.CUSTOMER);
        iCustomerRepository.save(newCustomer);

        return new ResponsePassCustomerDto(passwordGenerated);
        /*
        ResponsePassCustomerDto responsePassCustomerDto = new ResponsePassCustomerDto(passwordGenerated);
        return responsePassCustomerDto;
         */
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {

        if(iCustomerRepository.getCustomerByCardId(modifyCustomer.getCardId()).isEmpty()){ // Si la marca existe editela, sino esta vacio y retorne nulo
            return Optional.empty();                                             // Se usa para no tener Nulos y queda mas limpio
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    @Override
    public boolean delete(String cardId) {

        if(iCustomerRepository.getCustomerByCardId(cardId).isEmpty()){ // Si la marca existe editela, sino esta vacio y retorne nulo
            return false;                                   // Se usa para no tener Nulos y queda mas limpio
        }

        // Colocar else seria redundar
        iCustomerRepository.delete(cardId);
        return true;
    }






    // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    private static String generateRandomPassword(int len)
    {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

}
