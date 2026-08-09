package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Turno;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Sede;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.SedeRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private SedeRepository sedeRepository;

    @Transactional(readOnly = true)
    public List<Turno> listaTurno() {
        return turnoRepository.findAll();
    }


    public Turno registrarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public Turno updateTurno(Turno turno) {
        if (turno.getIdTurno() != null && turnoRepository.existsById(turno.getIdTurno())) {
            return turnoRepository.save(turno);
        }
        return null;
    }

    public boolean deleteTurno(Integer id) {
        if (id != null && turnoRepository.existsById(id)) {
            turnoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Turno insertarTurnoEjemplo() {
        Turno turno = new Turno();
        turno.setNombreTurno("Madrugada - Ejemplo");
        turno.setHoraInicio(LocalTime.of(21, 0, 0));
        turno.setHoraFin(LocalTime.of(7, 0, 0));

        Sede sede = sedeRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("La sede con ID 1 no existe"));

        turno.setSede(sede);

        return turnoRepository.save(turno);
    }

}
