package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Sede;
import com.pe.idat.sistema.clinica.sitema_clinica.service.SedeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pe.idat.sistema.clinica.sitema_clinica.Componente.JwtTokenProvider;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sede")

public class SedeController {
    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @GetMapping
    public ResponseEntity<Object> listaSede() {
        return ResponseEntity.ok(sedeService.listaSede());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> registrarSede(@RequestBody Sede sede) {
        return ResponseEntity.ok(sedeService.registrarSede(sede));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> actualizarSede(@RequestBody Sede sede) {
        return ResponseEntity.ok(sedeService.updateSede(sede));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> eliminarSede(@PathVariable Integer id) {
        return ResponseEntity.ok(sedeService.deleteSede(id));
    }

}
