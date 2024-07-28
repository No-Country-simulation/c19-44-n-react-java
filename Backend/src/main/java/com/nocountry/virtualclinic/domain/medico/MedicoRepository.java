package com.nocountry.virtualclinic.domain.medico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findFirstByEspecialidad(Especialidad especialidad);
}
