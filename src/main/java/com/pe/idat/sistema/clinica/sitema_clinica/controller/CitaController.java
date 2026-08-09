package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Cita;
import com.pe.idat.sistema.clinica.sitema_clinica.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cita")

public class CitaController {


    @Autowired
    private final CitasService citasService;

    public CitaController(CitasService citasService) {
        this.citasService = citasService;
    }

    @GetMapping
    public ResponseEntity<Object> listaCita() {
        return ResponseEntity.ok(citasService.listaCita());
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<Object> listarCitasPorPaciente(@PathVariable Integer idPaciente) {
        return ResponseEntity.ok(citasService.listarCitasPorPaciente(idPaciente));
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/usuario-medico/{idUsuario}")
    public ResponseEntity<List<Cita>> listarCitasPorUsuarioMedico(@PathVariable Integer idUsuario) {
        List<Cita> citas = citasService.listarCitasPorIdUsuarioMedico(idUsuario);
        return ResponseEntity.ok(citas);
    }

    @PostMapping
    public ResponseEntity<Object> registrarCita(@RequestBody Cita cita) {
        try {
            Cita nuevaCita = citasService.registrarCita(cita);
            return ResponseEntity.ok(nuevaCita);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al registrar: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> actualizarCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citasService.updateCita(cita));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> eliminarCita(@PathVariable Integer id) {
        return ResponseEntity.ok(citasService.deleteCita(id));
    }

}

