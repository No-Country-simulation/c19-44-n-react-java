package com.nocountry.virtualclinic.domain.user;

public record DatosRespuestaUsuario(
        Long usuarioId,
        String nombreUsuario,
        String login
) {
}
