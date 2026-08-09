package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.HistorialHospital;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Paciente;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.HistorialHospitalRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@Transactional

public class HistorialHospitalService {
    @Autowired
    private HistorialHospitalRepository historialHospitalRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    @Transactional(readOnly = true)
    public String obtenerUrlPdfPorPaciente(Integer idPaciente) {
        HistorialHospital historial = historialHospitalRepository.findByPaciente_IdPaciente(idPaciente).orElse(null);
        return (historial != null) ? historial.getArchivoPdf() : null;
    }

    @Transactional(readOnly = true)
    public HistorialHospital obtenerHistorialPorPaciente(Integer idPaciente) {
        return historialHospitalRepository.findByPaciente_IdPaciente(idPaciente).orElse(null);
    }


    public HistorialHospital registrarHistorial(HistorialHospital historial) {
        return historialHospitalRepository.save(historial);
    }

    public HistorialHospital updateHistorial(HistorialHospital historial) {
        if (historial.getIdHistorial() != null && historialHospitalRepository.existsById(historial.getIdHistorial())) {
            return historialHospitalRepository.save(historial);
        }
        return null;
    }

    public boolean deleteHistorial(Integer id) {
        if (id != null && historialHospitalRepository.existsById(id)) {
            historialHospitalRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public HistorialHospital insertarHistorialEjemplo() {
        HistorialHospital historial = new HistorialHospital();
        historial.setFechaCreacion(LocalDate.of(2026, 1, 23));

        String urlPdfStr = "https://aulavirtual.idat.edu.pe/mod/resource/view.php?id=1909080";
        historial.setArchivoPdf(urlPdfStr);

        Paciente paciente = pacienteRepository.findById(3)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        historial.setPaciente(paciente);

        return historialHospitalRepository.save(historial);
    }
}
