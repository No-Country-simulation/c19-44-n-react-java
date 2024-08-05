package com.nocountry.virtualclinic.domain.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nocountry.virtualclinic.domain.medico.Medico;

import java.time.LocalDateTime;

public record DatosRespuestaCita(
        String success,
        Long citaId,
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime fechaHora,
        Medico medico
) {
}
