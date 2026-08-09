package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Medico;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Turno;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Especialidad;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Usuario;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.MedicoRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.UsuarioRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.EspecialidadRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private  EspecialidadRepository especialidadRepository;
    @Autowired
    private TurnoRepository turnoRepository;

    @Transactional(readOnly = true)
    public List<Medico> listaMedico() {
        return medicoRepository.findAll();
    }


    public Medico registrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Medico medico) {
        if (medico.getIdMedico() != null && medicoRepository.existsById(medico.getIdMedico())) {
            return medicoRepository.save(medico);
        }
        return null;
    }

    public boolean deleteMedico(Integer id) {
        if (id != null && medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Medico insertarMedicoEjemplo() {
        Medico medico = new Medico();
        medico.setNombre("Wincha");
        medico.setApellido("Parker we");

        Usuario usuario = usuarioRepository.findById(6)
                .orElseThrow(() -> new RuntimeException("El usuario con ID 6 no existe"));

        Especialidad especialidad = especialidadRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        Turno turno = turnoRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        medico.setUsuario(usuario);
        medico.setEspecialidad(especialidad);
        medico.setTurno(turno);

        return medicoRepository.save(medico);
    }
}
