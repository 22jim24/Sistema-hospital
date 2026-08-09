package com.pe.idat.sistema.clinica.sitema_clinica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "historial_hospital",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_historial_paciente", columnNames = "id_paciente") //
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HistorialHospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @NotBlank
    @Lob
    @Column(name = "url_pdf", columnDefinition = "LONGBLOB", nullable = false)
    private String archivoPdf;

    //  1 a 1
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "fk_historial_paciente"))
    private Paciente paciente;
}


