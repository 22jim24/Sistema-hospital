package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(
        name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuario_email", columnNames = "email")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado", nullable = false, length = 30)
    private EstadoUsuario estado;

    // N a 1
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name = "fk_usuario_rol"))
    private Rol rol;

    public enum EstadoUsuario {
        ACTIVO_PACIENTE,
        ACTIVO_MEDICO,
        INACTIVO
    }
}
