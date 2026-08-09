package com.pe.idat.sistema.clinica.sitema_clinica.Componente;

import com.pe.idat.sistema.clinica.sitema_clinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;

//@Component
public class Init  implements CommandLineRunner {
    @Autowired private RolService rolService;
    @Autowired private SedeService sedeService;
    @Autowired private EspecialidadService especialidadService;
    @Autowired private UsuarioService usuarioService;
    @Autowired private TurnoService turnoService;
    @Autowired private PacienteService pacienteService;
    @Autowired private MedicoService medicoService;
    @Autowired private CitasService citasService;
    @Autowired private HistorialHospitalService historialHospitalService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spiderman ");

        rolService.insertarRolEjemplo();
        sedeService.insertarSedeEjemplo();
        especialidadService.insertarEspecialidadEjemplo();

        usuarioService.insertarUsuarioEjemplo();

        turnoService.insertarTurnoEjemplo();

        pacienteService.insertarPacienteEjemplo();

        medicoService.insertarMedicoEjemplo();

        citasService.agendarCitaMedicaEjemplo();

        historialHospitalService.insertarHistorialEjemplo();

        System.out.println("pickachu raichu");
    }
}
