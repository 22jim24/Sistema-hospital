package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(
        name = "rol",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_rol_nombre", columnNames = "nombre_rol")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombreRol;

}
