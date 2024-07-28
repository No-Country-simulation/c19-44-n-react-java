package com.nocountry.virtualclinic.domain.cita;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosModificarCita(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime nuevaFechaHora
) {
}
