package com.pe.idat.sistema.clinica.sitema_clinica.repository;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
