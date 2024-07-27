package com.nocountry.virtualclinic.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosRegistroUsuario(
        @NotNull
        @Email
        String login,
        @NotNull
        @Size(min = 6)
        String clave
) {
}
