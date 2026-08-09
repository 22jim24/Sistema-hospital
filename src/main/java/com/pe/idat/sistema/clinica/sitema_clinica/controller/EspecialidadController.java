package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Especialidad;
import com.pe.idat.sistema.clinica.sitema_clinica.service.EspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pe.idat.sistema.clinica.sitema_clinica.Componente.JwtTokenProvider;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/especialidad")

public class EspecialidadController {
    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public ResponseEntity<Object> listaEspecialidad() {
        return ResponseEntity.ok(especialidadService.listaEspecialidad());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> registrarEspecialidad(@RequestBody Especialidad especialidad) {
        return ResponseEntity.ok(especialidadService.registrarEspecialidad(especialidad));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> actualizarEspecialidad(@RequestBody Especialidad especialidad) {
        return ResponseEntity.ok(especialidadService.updateEspecialidad(especialidad));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> eliminarEspecialidad(@PathVariable Integer id) {
        return ResponseEntity.ok(especialidadService.deleteEspecialidad(id));
    }

}
