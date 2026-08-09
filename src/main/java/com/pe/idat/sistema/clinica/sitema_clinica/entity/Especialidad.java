package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(
        name = "especialidad",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_especialidad_nombre", columnNames = "nombre_especialidad")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;

    @NotBlank(message = "El nombre de la especialidad es obligatorio")
    @Size(max = 100)
    @Column(name = "nombre_especialidad", nullable = false, length = 100)
    private String nombreEspecialidad;

}
