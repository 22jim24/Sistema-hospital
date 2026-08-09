package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Especialidad;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional(readOnly = true)
    public List<Especialidad> listaEspecialidad() {
        return especialidadRepository.findAll();
    }


    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Especialidad updateEspecialidad(Especialidad especialidad) {
        if (especialidad.getIdEspecialidad() != null && especialidadRepository.existsById(especialidad.getIdEspecialidad())) {
            return especialidadRepository.save(especialidad);
        }
        return null;
    }

    public boolean deleteEspecialidad(Integer id) {
        if (id != null && especialidadRepository.existsById(id)) {
            especialidadRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Especialidad insertarEspecialidadEjemplo() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("General ejemplo");
        return especialidadRepository.save(especialidad);
    }
}
