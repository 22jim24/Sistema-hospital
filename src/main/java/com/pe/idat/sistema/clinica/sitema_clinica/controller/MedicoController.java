package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Medico;
import com.pe.idat.sistema.clinica.sitema_clinica.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/medico")

public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<Object> listaMedico() {
        return ResponseEntity.ok(medicoService.listaMedico());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")

    public ResponseEntity<Object> registrarMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.registrarMedico(medico));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> actualizarMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.updateMedico(medico));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> eliminarMedico(@PathVariable Integer id) {
        return ResponseEntity.ok(medicoService.deleteMedico(id));
    }

}
