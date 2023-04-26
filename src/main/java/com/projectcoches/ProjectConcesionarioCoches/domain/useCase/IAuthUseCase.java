package com.projectcoches.ProjectConcesionarioCoches.domain.useCase;

import com.projectcoches.ProjectConcesionarioCoches.domain.dto.AuthCustomerDto;
import com.projectcoches.ProjectConcesionarioCoches.domain.dto.JwtResponseDto;

public interface IAuthUseCase {
    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}
