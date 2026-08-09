package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Turno;
import com.pe.idat.sistema.clinica.sitema_clinica.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/turno")

public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<Object> listaTurno() {
        return ResponseEntity.ok(turnoService.listaTurno());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> registrarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> actualizarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> eliminarTurno(@PathVariable Integer id) {
        return ResponseEntity.ok(turnoService.deleteTurno(id));
    }

}
