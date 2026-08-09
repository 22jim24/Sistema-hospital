package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Paciente;
import com.pe.idat.sistema.clinica.sitema_clinica.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/paciente")

public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<Object> listaPaciente() {
        return ResponseEntity.ok(pacienteService.listaPaciente());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")

    public ResponseEntity<Object> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")

    public ResponseEntity<Object> actualizarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.updatePaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")

    public ResponseEntity<Object> eliminarPaciente(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.deletePaciente(id));
    }

}
