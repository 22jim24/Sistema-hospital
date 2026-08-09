package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Table(name = "turno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Integer idTurno;

    @Column(name = "nombre_turno", nullable = false, length = 50)
    private String nombreTurno;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    // N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sede", nullable = false, foreignKey = @ForeignKey(name = "fk_turno_sede"))
    private Sede sede;

}
