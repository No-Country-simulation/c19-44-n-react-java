package com.nocountry.virtualclinic.domain.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCrearCita(
        @NotNull
        Long usuarioId,
        @NotNull
        Long medicoId,
        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime fechaHora
) {
}
