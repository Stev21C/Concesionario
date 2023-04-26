package com.projectcoches.ProjectConcesionarioCoches.exception;

public class CustomerNotExistException extends RuntimeException {


    public CustomerNotExistException() {
        super("El usuario ingresado no existe.");
    }
}
