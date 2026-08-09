package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Rol;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class RolService {
    @Autowired
    private RolRepository rolRepository;

    @Transactional(readOnly = true)
    public List<Rol> listaRol() {
        return rolRepository.findAll();
    }


    public Rol registrarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol updateRol(Rol rol) {
        if (rol.getIdRol() != null && rolRepository.existsById(rol.getIdRol())) {
            return rolRepository.save(rol);
        }
        return null;
    }

    public boolean deleteRol(Integer id) {
        if (id != null && rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Rol insertarRolEjemplo() {
        Rol rol = new Rol();
        rol.setNombreRol("Ejemplo");
        return rolRepository.save(rol);
    }
}
