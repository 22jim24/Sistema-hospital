package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.HistorialHospital;
import com.pe.idat.sistema.clinica.sitema_clinica.service.HistorialHospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/historial")

public class HistorialHospitalController {
    private final HistorialHospitalService historialService;

    public HistorialHospitalController(HistorialHospitalService historialService) {this.historialService = historialService;}

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<Object> obtenerHistorialPorPaciente(@PathVariable Integer idPaciente) {
        HistorialHospital historial = historialService.obtenerHistorialPorPaciente(idPaciente);
        if (historial != null) {
            return ResponseEntity.ok(historial);
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<Object> registrarHistorial(@RequestBody HistorialHospital historial) {
        return ResponseEntity.ok(historialService.registrarHistorial(historial));
    }

    @PutMapping
    public ResponseEntity<Object> actualizarHistorial(@RequestBody HistorialHospital historial) {
        return ResponseEntity.ok(historialService.updateHistorial(historial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarHistorial(@PathVariable Integer id) {
        return ResponseEntity.ok(historialService.deleteHistorial(id));
    }

}
