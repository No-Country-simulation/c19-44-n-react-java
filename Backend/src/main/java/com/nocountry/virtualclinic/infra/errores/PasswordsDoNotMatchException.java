package com.nocountry.virtualclinic.infra.errores;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException(String mensaje) {
        super(mensaje);
    }
}
