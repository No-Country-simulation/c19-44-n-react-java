package com.nocountry.virtualclinic.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank(message = "Su login es requerido")
        @Email
        String login,
        @NotBlank(message = "Por favor escriba su clave")
        String clave
) {
}
