package com.nocountry.virtualclinic.domain.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nocountry.virtualclinic.domain.medico.Especialidad;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCrearCita(
        @NotNull
        Long usuarioId,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime fechaHora
) {
}
