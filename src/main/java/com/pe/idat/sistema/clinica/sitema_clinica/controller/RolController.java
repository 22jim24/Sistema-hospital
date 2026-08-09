package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Rol;
import com.pe.idat.sistema.clinica.sitema_clinica.service.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rol")

public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<Object> listaRol() {
        return ResponseEntity.ok(rolService.listaRol());
    }

    @PostMapping
    public ResponseEntity<Object> registrarRol(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.registrarRol(rol));
    }

    @PutMapping
    public ResponseEntity<Object> actualizarRol(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.updateRol(rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarRol(@PathVariable Integer id) {
        return ResponseEntity.ok(rolService.deleteRol(id));
    }

}
