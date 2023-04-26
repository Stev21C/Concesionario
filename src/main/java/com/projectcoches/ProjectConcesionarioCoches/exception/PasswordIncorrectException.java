package com.projectcoches.ProjectConcesionarioCoches.exception;

public class PasswordIncorrectException extends RuntimeException {

    public PasswordIncorrectException() {
        super("La contraseña es inválida.");
    }
}
