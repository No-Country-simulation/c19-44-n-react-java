package com.nocountry.virtualclinic.domain.cita;

import com.nocountry.virtualclinic.domain.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByUsuarioAndFechaHoraAfter(AppUser usuario, LocalDateTime fechaHora);
}