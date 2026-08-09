package com.pe.idat.sistema.clinica.sitema_clinica.repository;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.HistorialHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface HistorialHospitalRepository extends JpaRepository<HistorialHospital, Integer> {

    Optional<HistorialHospital> findByPaciente_IdPaciente(Integer idPaciente);

}
