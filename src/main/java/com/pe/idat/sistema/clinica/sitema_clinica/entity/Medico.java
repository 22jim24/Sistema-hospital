package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(
        name = "medico",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_medico_usuario", columnNames = "id_usuario")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank @Size(max = 100)
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    // 1 a 1
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_medico_usuario"))
    private Usuario usuario;

    // N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "fk_medico_especialidad"))
    private Especialidad especialidad;

    //N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_turno", nullable = false, foreignKey = @ForeignKey(name = "fk_medico_turno"))
    private Turno turno;

}
