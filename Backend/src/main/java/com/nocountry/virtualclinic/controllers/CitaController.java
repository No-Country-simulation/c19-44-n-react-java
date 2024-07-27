package com.nocountry.virtualclinic.controllers;

import com.nocountry.virtualclinic.domain.cita.Cita;
import com.nocountry.virtualclinic.domain.cita.DatosCrearCita;
import com.nocountry.virtualclinic.domain.cita.DatosModificarCita;
import com.nocountry.virtualclinic.domain.cita.DatosRespuestaCita;
import com.nocountry.virtualclinic.service.CitaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<DatosRespuestaCita> crearCita(@RequestBody DatosCrearCita dto) {
        Cita cita = citaService.crearCita(dto.usuarioId(), dto.medicoId(), dto.fechaHora());
        var datosRespuestaCita = new DatosRespuestaCita(cita.getFechaHora(), cita.getMedico());
        return ResponseEntity.ok(datosRespuestaCita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> modificarCita(@PathVariable Long id, @RequestBody DatosModificarCita dto) {
        Cita cita = citaService.modificarCita(id, dto.nuevaFechaHora());
        return new ResponseEntity<>(cita, HttpStatus.OK);
    }

    @GetMapping("/upcoming/{usuarioId}")
    public ResponseEntity<List<Cita>> obtenerCitasPendientes(@PathVariable Long usuarioId) {
        List<Cita> citas = citaService.obtenerCitasPendientes(usuarioId);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
}