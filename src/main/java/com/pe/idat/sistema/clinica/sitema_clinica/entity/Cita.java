package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "cita",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_cita_medico_fechahora", columnNames = {"id_medico", "fecha_hora"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;

    @NotNull(message = "La fecha y hora es obligatoria")
    @FutureOrPresent(message = "La cita no puede ser en el pasado")
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @NotNull(message = "El estado de la cita es obligatorio")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado_cita", nullable = false, length = 20)
    private EstadoCita estadoCita;

    //  N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_cita_paciente"))
    private Paciente paciente;

    // N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(name = "fk_cita_medico"))
    private Medico medico;

    // N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_sede", nullable = false, foreignKey = @ForeignKey(name = "fk_cita_sede"))
    private Sede sede;

    public enum EstadoCita {
        ESPERANDO,
        CONFIRMADA,
        CANCELADA,
        COMPLETADA
    }
}
