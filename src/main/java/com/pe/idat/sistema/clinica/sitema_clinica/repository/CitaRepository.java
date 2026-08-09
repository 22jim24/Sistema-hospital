package com.pe.idat.sistema.clinica.sitema_clinica.repository;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CitaRepository extends JpaRepository<Cita, Integer>{

    List<Cita> findByMedico_Usuario_IdUsuario(Integer id_Usuario);

    List<Cita> findByPaciente_IdPaciente(Integer id_Paciente);
}
