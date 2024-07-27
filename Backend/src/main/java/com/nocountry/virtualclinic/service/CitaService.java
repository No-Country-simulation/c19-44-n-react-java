package com.nocountry.virtualclinic.service;

import com.nocountry.virtualclinic.domain.cita.Cita;
import com.nocountry.virtualclinic.domain.cita.CitaRepository;
import com.nocountry.virtualclinic.domain.medico.Medico;
import com.nocountry.virtualclinic.domain.medico.MedicoRepository;
import com.nocountry.virtualclinic.domain.user.AppUser;
import com.nocountry.virtualclinic.domain.user.AppUserRepository;
import com.nocountry.virtualclinic.infra.errores.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private AppUserRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private CitaRepository citaRepository;

    public Cita crearCita(Long usuarioId, Long medicoId, LocalDateTime fechaHora) {
        AppUser usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Medico no encontrado"));

        Cita cita = new Cita(usuario, medico, fechaHora);
        return citaRepository.save(cita);
    }

    @Transactional
    public void eliminarCita(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cita not found with id " + id);
        }
        citaRepository.deleteById(id);
    }

    @Transactional
    public Cita modificarCita(Long citaId, LocalDateTime nuevaFechaHora) {
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setFechaHora(nuevaFechaHora);
        return citaRepository.save(cita);
    }

    public List<Cita> obtenerCitasPendientes(Long usuarioId) {
        AppUser usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return citaRepository.findByUsuarioAndFechaHoraAfter(usuario, LocalDateTime.now());
    }
}
