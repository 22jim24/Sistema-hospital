package com.pe.idat.sistema.clinica.sitema_clinica.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(
        name = "paciente",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_paciente_dni", columnNames = "dni"),
                @UniqueConstraint(name = "uk_paciente_usuario", columnNames = "id_usuario")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @NotBlank
    @Size(max = 8)
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Size(min=9 ,max = 9)
    @Column(name = "telefono", length = 9)
    private String telefono;

    // 1 a 1
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_paciente_usuario"))
    private Usuario usuario;

}
