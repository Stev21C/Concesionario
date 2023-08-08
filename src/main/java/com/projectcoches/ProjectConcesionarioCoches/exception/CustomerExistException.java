package com.projectcoches.ProjectConcesionarioCoches.exception;

public class CustomerExistException extends Throwable {

    public CustomerExistException() {
        super("El usuario ingresado no existe.");
    }
}
