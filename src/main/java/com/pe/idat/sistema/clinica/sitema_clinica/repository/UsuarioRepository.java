package com.pe.idat.sistema.clinica.sitema_clinica.repository;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
}
