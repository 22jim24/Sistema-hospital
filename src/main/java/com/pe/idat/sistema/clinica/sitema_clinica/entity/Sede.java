package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(
        name = "sede",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_sede_nombre", columnNames = "nombre_sede")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Integer idSede;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre_sede", nullable = false, length = 100)
    private String nombreSede;

    @Size(max = 200)
    @Column(name = "direccion", length = 200)
    private String direccion;

}


