package com.nocountry.virtualclinic.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosRegistroUsuario(
        @NotBlank
        String nombreUsuario,
        @NotBlank
        @Email
        String login,
        @NotBlank
        @Size(min = 6, message = "La clave debe tener como mínimo 6 caracteres")
        String clave,
        @NotBlank
        String confirmaClave
) {
}
