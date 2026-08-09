package com.pe.idat.sistema.clinica.sitema_clinica.Componente;

import com.pe.idat.sistema.clinica.sitema_clinica.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final Key jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private final long jwtExpirationInMs = 86400000;

    public String generateToken(Usuario usuario) {
        Date ahora = new Date();
        Date fechaExpiracion = new Date(ahora.getTime() + jwtExpirationInMs);

        String estadoStr = "";
        if (usuario.getEstado() != null) {
            estadoStr = usuario.getEstado().name();
        }

        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("estado", estadoStr)
                .setIssuedAt(new Date())
                .setExpiration(fechaExpiracion)
                .signWith(jwtSecret)
                .compact();
    }

    public Key getJwtSecret() {
        return jwtSecret;
    }
}
