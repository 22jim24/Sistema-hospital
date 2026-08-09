package com.pe.idat.sistema.clinica.sitema_clinica.controller;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Usuario;
import com.pe.idat.sistema.clinica.sitema_clinica.service.UsuarioService;

import com.pe.idat.sistema.clinica.sitema_clinica.Componente.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")

public class UsuarioController {
    private final UsuarioService usuarioService;
    private final JwtTokenProvider jwtTokenProvider;

    public UsuarioController(UsuarioService usuarioService, JwtTokenProvider jwtTokenProvider) {
        this.usuarioService = usuarioService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<List<Usuario>> listaUsuario() {
        return ResponseEntity.ok(usuarioService.listaUsuario());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        if (nuevoUsuario != null) {
            return ResponseEntity.ok(nuevoUsuario);
        }
        return ResponseEntity.badRequest().body("No se pudo registrar el usuario");
    }


    @PutMapping
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(usuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        }
        return ResponseEntity.badRequest().body("No se pudo actualizar el usuario (ID no existe)");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ACTIVO_MEDICO')")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Integer id) {
        boolean eliminado = usuarioService.deleteUsuario(id);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario usuarioLogin) {
        Usuario usuarioValidado = usuarioService.validarLogin(usuarioLogin.getEmail(), usuarioLogin.getPassword());

        if (usuarioValidado != null) {
            String token = jwtTokenProvider.generateToken(usuarioValidado);

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("mensaje", "Login exitoso");
            respuesta.put("token", token);
            respuesta.put("usuario", usuarioValidado);

            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(401).body("Correo o contraseña incorrectos");
        }
    }

}
