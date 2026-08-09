package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Paciente;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Usuario;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.PacienteRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Paciente> listaPaciente() {return pacienteRepository.findAll();
    }


    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Paciente paciente) {
        if (paciente.getIdPaciente() != null && pacienteRepository.existsById(paciente.getIdPaciente())) {
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public boolean deletePaciente(Integer id) {
        if (id != null && pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Paciente insertarPacienteEjemplo() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Leon");
        paciente.setApellido("Narz Cat");
        paciente.setDni("71355169");
        paciente.setTelefono("995425667");

        Usuario usuario = usuarioRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("El usuario con ID 4 no existe"));

        paciente.setUsuario(usuario);

        return pacienteRepository.save(paciente);
    }

}
