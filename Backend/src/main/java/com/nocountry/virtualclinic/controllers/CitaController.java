package com.nocountry.virtualclinic.controllers;

import com.nocountry.virtualclinic.domain.cita.*;
import com.nocountry.virtualclinic.service.CitaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    String success = "true";

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<DatosRespuestaCita> crearCita(@RequestBody DatosCrearCita dto) {
        Cita cita = citaService.crearCita(dto.usuarioId(), dto.especialidad(), dto.fechaHora());
        var datosRespuestaCita = new DatosRespuestaCita(success, cita.getCitaId(), cita.getFechaHora(), cita.getMedico());
        return ResponseEntity.ok(datosRespuestaCita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaCita> modificarCita(@PathVariable Long id, @RequestBody DatosModificarCita dto) {
        Cita cita = citaService.modificarCita(id, dto.nuevaFechaHora());
        var datosRespuestaCita = new DatosRespuestaCita(success, cita.getCitaId(), cita.getFechaHora(), cita.getMedico());
        return ResponseEntity.ok(datosRespuestaCita);
    }

    @GetMapping("/upcoming/{usuarioId}")
    public ResponseEntity<List<DatosRespuestaCita>> obtenerCitasPendientes(@PathVariable Long usuarioId) {
        List<Cita> citas = citaService.obtenerCitasPendientes(usuarioId);
        List<DatosRespuestaCita> citasPendiente = citas.stream().map(c -> new DatosRespuestaCita(success, c.getCitaId(), c.getFechaHora(), c.getMedico())).toList();
        return ResponseEntity.ok(citasPendiente);
    }


    @GetMapping("/pendientes")
    public ResponseEntity<List<Cita>> obtenerCitasPendientes() {
        List<Cita> citasPendientes = citaService.obtenerCitasPendientes();
        return ResponseEntity.ok(citasPendientes);
    }

    @GetMapping("/caducadas")
    public ResponseEntity<List<Cita>> obtenerCitasCaducadas() {
        List<Cita> citasCaducadas = citaService.obtenerCitasCaducadas();
        return ResponseEntity.ok(citasCaducadas);
    }

}