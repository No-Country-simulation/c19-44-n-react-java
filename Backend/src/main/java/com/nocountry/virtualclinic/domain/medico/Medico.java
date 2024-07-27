package com.nocountry.virtualclinic.domain.medico;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long medicoId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;


}
