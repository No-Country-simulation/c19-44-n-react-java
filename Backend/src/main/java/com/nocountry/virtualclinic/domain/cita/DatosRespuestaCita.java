package com.nocountry.virtualclinic.domain.cita;

import com.nocountry.virtualclinic.domain.medico.Medico;

import java.time.LocalDateTime;

public record DatosRespuestaCita(
        LocalDateTime fechaHora,
        Medico medico
) {
}
