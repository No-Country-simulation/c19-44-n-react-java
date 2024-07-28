package com.nocountry.virtualclinic.infra.errores;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String mensaje) {
        super(mensaje);
    }
}
