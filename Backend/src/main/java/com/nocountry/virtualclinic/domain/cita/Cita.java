package com.nocountry.virtualclinic.domain.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nocountry.virtualclinic.domain.medico.Medico;
import com.nocountry.virtualclinic.domain.user.AppUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")

@Getter
@Setter
@NoArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cita_id")
    private Long citaId;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private AppUser usuario;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Cita(AppUser usuario, Medico medico, LocalDateTime fechaHora) {
        this.usuario = usuario;
        this.medico = medico;
        this.fechaHora = fechaHora;
    }

}
