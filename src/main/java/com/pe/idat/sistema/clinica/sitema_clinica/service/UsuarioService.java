package com.pe.idat.sistema.clinica.sitema_clinica.service;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Usuario;
import com.pe.idat.sistema.clinica.sitema_clinica.entity.Rol;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.UsuarioRepository;
import com.pe.idat.sistema.clinica.sitema_clinica.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() != null && usuarioRepository.existsById(usuario.getIdUsuario())) {

            Usuario usuarioExistente = usuarioRepository.findById(usuario.getIdUsuario()).get();

            if (usuario.getPassword() != null && !usuario.getPassword().equals(usuarioExistente.getPassword())) {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            } else {
                usuario.setPassword(usuarioExistente.getPassword());
            }

            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean deleteUsuario(Integer id) {
        if (id != null && usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuario validarLogin(String email, String passwordPlano) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(passwordPlano, usuario.getPassword())) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario insertarUsuarioEjemplo() {
        Usuario usuario = new Usuario();
        usuario.setEmail("ejemplo@clinica.pe");

        usuario.setPassword(passwordEncoder.encode("ejemp12"));

        usuario.setEstado(Usuario.EstadoUsuario.ACTIVO_PACIENTE);

        Rol rol = rolRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("El rol con ID 2 no existe"));

        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }
}
