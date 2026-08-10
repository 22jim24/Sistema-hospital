package com.pe.idat.sistema.clinica.sitema_clinica.Componente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    public WebSecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/usuario").permitAll()

                        .requestMatchers(HttpMethod.GET, "/sede/**").hasAuthority("ROLE_ACTIVO_PACIENTE")
                        .requestMatchers(HttpMethod.GET, "/especialidad/**").hasAuthority("ROLE_ACTIVO_PACIENTE")
                        .requestMatchers(HttpMethod.GET, "/turno/**").hasAuthority("ROLE_ACTIVO_PACIENTE")
                        .requestMatchers(HttpMethod.GET, "/paciente/**").hasAuthority("ROLE_ACTIVO_PACIENTE")
                        .requestMatchers(HttpMethod.GET, "/medico/**").hasAuthority("ROLE_ACTIVO_PACIENTE") 
                        .requestMatchers(HttpMethod.GET, "/cita/paciente/**").hasAuthority("ROLE_ACTIVO_PACIENTE") 
                        .requestMatchers(HttpMethod.POST, "/cita").hasAuthority("ROLE_ACTIVO_PACIENTE")

                        .requestMatchers("/historial/**").hasAuthority("ROLE_ACTIVO_MEDICO")
                        .requestMatchers("/medico/**").hasAuthority("ROLE_ACTIVO_MEDICO")
                        .requestMatchers(HttpMethod.PUT, "/cita").hasAuthority("ROLE_ACTIVO_MEDICO")
                        .requestMatchers("/cita/**").hasAuthority("ROLE_ACTIVO_MEDICO")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider.getJwtSecret()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
