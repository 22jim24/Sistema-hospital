package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.*;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.CitaRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.SedeRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.PacienteRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.MedicoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class CitasService {
    @Autowired
    private CitaRepository citasRepository;
    @Autowired
    private SedeRepository sedeRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HistorialHospitalService historialHospitalService;



    @Transactional(readOnly = true)
    public List<Cita> listaCita() {
        return citasRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Cita> listarCitasPorPaciente(Integer idPaciente) {
        return citasRepository.findByPaciente_IdPaciente(idPaciente);
    }


    @Transactional(readOnly = true)
    public List<Cita> listarCitasPorMedico(Integer idMedico) {
        return citasRepository.findAll().stream()
                .filter(c -> c.getMedico() != null && c.getMedico().getIdMedico().equals(idMedico))
                .toList();
    }


    public List<Cita> listarCitasPorIdUsuarioMedico(Integer idUsuario) {
        Medico medico = medicoRepository.findAll().stream()
                .filter(m -> m.getUsuario() != null && m.getUsuario().getIdUsuario().equals(idUsuario))
                .findFirst()
                .orElse(null);

        if (medico == null) {
            return new ArrayList<>();
        }

        return listarCitasPorMedico(medico.getIdMedico());
    }

    public Cita registrarCita(Cita cita) {
        if (cita.getPaciente() != null && cita.getPaciente().getIdPaciente() != null) {
            Paciente paciente = pacienteRepository.findById(cita.getPaciente().getIdPaciente())
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
            cita.setPaciente(paciente);
        }

        if (cita.getMedico() != null && cita.getMedico().getIdMedico() != null) {
            Medico medico = medicoRepository.findById(cita.getMedico().getIdMedico())
                    .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
            cita.setMedico(medico);
        }

        if (cita.getSede() != null && cita.getSede().getIdSede() != null) {
            Sede sede = sedeRepository.findById(cita.getSede().getIdSede())
                    .orElseThrow(() -> new RuntimeException("Sede no encontrada"));
            cita.setSede(sede);
        }

        return citasRepository.save(cita);
    }

    public Cita updateCita(Cita cita) {
        if (cita.getIdCita() != null && citasRepository.existsById(cita.getIdCita())) {
            Cita citaExistente = citasRepository.findById(cita.getIdCita())
                    .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

            citaExistente.setEstadoCita(cita.getEstadoCita());

            return citasRepository.save(citaExistente);
        }
        return null;
    }

    public boolean deleteCita(Integer id) {
        if (id != null && citasRepository.existsById(id)) {
            citasRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Cita agendarCitaMedicaEjemplo() {
        Cita nuevaCita = new Cita();
        nuevaCita.setFechaHora(LocalDateTime.of(2026, 8, 1, 9, 0, 0));
        nuevaCita.setEstadoCita(Cita.EstadoCita.CONFIRMADA);

        Paciente paciente = pacienteRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Medico medico = medicoRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
        Sede sede = sedeRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Sede no encontrada"));

        nuevaCita.setPaciente(paciente);
        nuevaCita.setMedico(medico);
        nuevaCita.setSede(sede);

        return citasRepository.save(nuevaCita);
    }

    public List<Cita> obtenerCitasPorUsuarioMedico(Integer idUsuarioMedico) {
        List<Cita> listaCitas = citasRepository.findByMedico_Usuario_IdUsuario(idUsuarioMedico);

        for (Cita cita : listaCitas) {
            if (cita.getPaciente() != null) {
                Integer idPaciente = cita.getPaciente().getIdPaciente();

                String urlPdf = historialHospitalService.obtenerUrlPdfPorPaciente(idPaciente);
            }
        }
        return listaCitas;
    }


}
