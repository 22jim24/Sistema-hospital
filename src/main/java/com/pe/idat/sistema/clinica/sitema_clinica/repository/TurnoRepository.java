package com.pe.idat.sistema.clinica.sitema_clinica.repository;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TurnoRepository extends JpaRepository<Turno, Integer>{
}
