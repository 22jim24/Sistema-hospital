package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Sede;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Transactional(readOnly = true)
    public List<Sede> listaSede() {
        return sedeRepository.findAll();
    }


    public Sede registrarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public Sede updateSede(Sede sede) {
        if (sede.getIdSede() != null && sedeRepository.existsById(sede.getIdSede())) {
            return sedeRepository.save(sede);
        }
        return null;
    }

    public boolean deleteSede(Integer id) {
        if (id != null && sedeRepository.existsById(id)) {
            sedeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Sede insertarSedeEjemplo() {
        Sede sede = new Sede();
        sede.setNombreSede("Sede ejemplo");
        sede.setDireccion("Calle del ejemplo");
        return sedeRepository.save(sede);
    }

}
