package com.nocountry.virtualclinic.infra.security.config;

public record DatosJWTToken(
        String token,
        Long usuarioId
) {
}
