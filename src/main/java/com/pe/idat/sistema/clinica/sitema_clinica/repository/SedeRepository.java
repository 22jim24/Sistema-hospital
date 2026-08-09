package com.pe.idat.sistema.clinica.sitema_clinica.repository;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SedeRepository extends JpaRepository<Sede, Integer>{
}
