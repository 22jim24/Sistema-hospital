package com.pe.idat.sistema.clinica.sitema_clinica.repository;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MedicoRepository extends JpaRepository<Medico, Integer>{
}
