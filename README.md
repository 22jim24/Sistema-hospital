# Sistema de Clínica - API REST

## Descripción del Proyecto
Desarrollamos una API REST para la gestión integral de una clínica u hospital, abarcando el control de citas, médicos, pacientes, especialidades, sedes, turnos, historiales médicos, roles y usuarios con autenticación mediante JWT (JSON Web Token) y Spring Security.

La aplicación permite registrar, listar, buscar, actualizar y eliminar información a través de solicitudes HTTP utilizando una base de datos MySQL (`clinica_DB`).


## INTEGRANTES
- JIMMY NARAZAS
- ANDRES UGARTE
- MIRELLA ZEVALLOS 
- HCETOR LLOCCE
  
## Tecnologías y Herramientas
* **Java 17**: Lenguaje de programación principal.
* **Spring Boot**: Framework para el desarrollo de la API REST.
* **Spring Security & JWT**: Gestión de seguridad, autenticación y autorización mediante tokens.
* **MySQL**: Sistema de gestión de base de datos relacional (`clinica_DB`).
* **Spring Data JPA**: Conexión y persistencia de datos mediante entidades.
* **Maven**: Administrador de dependencias y compilación.
* **Postman**: Pruebas de endpoints y solicitudes HTTP.
* **Swagger / OpenAPI**: Documentación interactiva de la API.

## Estructura del Proyecto
El proyecto se encuentra organizado bajo el paquete `com.pe.idat.sistema.clinica.sitema_clinica`:

El proyecto se encuentra organizado bajo el paquete `com.pe.idat.sistema.clinica.sitema_clinica`:

```text
src/
├── main/
│   ├── java/com/pe/idat/sistema/clinica/sitema_clinica/
│   │   ├── Componente/
│   │   │   ├── Init.java
│   │   │   ├── JwtTokenFilter.java
│   │   │   ├── JwtTokenProvider.java
│   │   │   ├── SecurityConfig.java
│   │   │   └── WebSecurityConfig.java
│   │   ├── controller/
│   │   │   ├── CitaController.java
│   │   │   ├── EspecialidadController.java
│   │   │   ├── HistorialHospitalController.java
│   │   │   ├── MedicoController.java
│   │   │   ├── PacienteController.java
│   │   │   ├── RolController.java
│   │   │   ├── SedeController.java
│   │   │   ├── TurnoController.java
│   │   │   └── UsuarioController.java
│   │   ├── service/
│   │   │   ├── CitasService.java
│   │   │   ├── EspecialidadService.java
│   │   │   ├── HistorialHospitalService.java
│   │   │   ├── MedicoService.java
│   │   │   ├── PacienteService.java
│   │   │   ├── RolService.java
│   │   │   ├── SedeService.java
│   │   │   ├── TurnoService.java
│   │   │   └── UsuarioService.java
│   │   ├── repository/
│   │   │   ├── CitaRepository.java
│   │   │   ├── EspecialidadRepository.java
│   │   │   ├── HistorialHospitalRepository.java
│   │   │   ├── MedicoRepository.java
│   │   │   ├── PacienteRepository.java
│   │   │   ├── RolRepository.java
│   │   │   ├── SedeRepository.java
│   │   │   ├── TurnoRepository.java
│   │   │   └── UsuarioRepository.java
│   │   ├── entity/
│   │   │   ├── Cita.java
│   │   │   ├── Especialidad.java
│   │   │   ├── HistorialHospital.java
│   │   │   ├── Medico.java
│   │   │   ├── Paciente.java
│   │   │   ├── Rol.java
│   │   │   ├── Sede.java
│   │   │   ├── Turno.java
│   │   │   └── Usuario.java
│   │   └── SitemaClinicaApplication.java
```
Funciones Principales por Módulo
Citas: Programación, listado, búsqueda por ID, actualización y cancelación/anulación de citas médicas.

Médicos: Registro, asignación de especialidades, listado y administración del staff médico.

Pacientes: Gestión de datos personales y expediente clínico de los pacientes.

Especialidades: Control de las ramas médicas disponibles en el hospital.

Sedes: Administración de las distintas sucursales o locaciones de la clínica.

Turnos: Configuración de horarios de atención.

Historial Médico: Seguimiento clínico del paciente dentro de la institución.

## SPRING SECURITY

Spring Security es una herramienta de Spring que permite proteger una aplicación mediante autenticación y autorización.

Puede utilizarse para:

- Solicitar usuario y contraseña.
- Proteger determinados endpoints.
- Asignar roles, como administrador o vendedor.
- Evitar que personas no autorizadas modifiquen o eliminen información.
- Implementar autenticación mediante tokens JWT.

Configuración de la Base de Datos
Se debe crear la base de datos en MySQL utilizando el siguiente comando SQL:

CREATE DATABASE clinica_DB;


Actualiza las credenciales de conexión en el archivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/clinica_DB?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña

## ENDPOINTS PRINCIPALES

| Módulo | Método | Endpoint | Función |
|---|---|---|---|
| Usuario | GET | `/usuario` | Listar todos los usuarios |
| Usuario | PUT | `/usuario` | Actualizar un usuario |
| Usuario | POST | `/usuario` | Registrar un usuario |
| Usuario | POST | `/usuario/login` | Iniciar sesión y generar token JWT |
| Usuario | DELETE | `/usuario/{id}` | Eliminar un usuario por ID |
| Turno | GET | `/turno` | Listar todos los turnos |
| Turno | PUT | `/turno` | Actualizar un turno |
| Turno | POST | `/turno` | Registrar un turno |
| Turno | DELETE | `/turno/{id}` | Eliminar un turno por ID |
| Sede | GET | `/sede` | Listar todas las sedes |
| Sede | PUT | `/sede` | Actualizar una sede |
| Sede | POST | `/sede` | Registrar una sede |
| Sede | DELETE | `/sede/{id}` | Eliminar una sede por ID |
| Rol | GET | `/rol` | Listar todos los roles |
| Rol | PUT | `/rol` | Actualizar un rol |
| Rol | POST | `/rol` | Registrar un rol |
| Rol | DELETE | `/rol/{id}` | Eliminar un rol por ID |
| Paciente | GET | `/paciente` | Listar todos los pacientes |
| Paciente | PUT | `/paciente` | Actualizar un paciente |
| Paciente | POST | `/paciente` | Registrar un paciente |
| Paciente | DELETE | `/paciente/{id}` | Eliminar un paciente por ID |
| Médico | GET | `/medico` | Listar todos los médicos |
| Médico | PUT | `/medico` | Actualizar un médico |
| Médico | POST | `/medico` | Registrar un médico |
| Médico | DELETE | `/medico/{id}` | Eliminar un médico por ID |
| Historial | PUT | `/historial` | Actualizar un registro del historial médico |
| Historial | POST | `/historial` | Registrar un historial médico |
| Historial | GET | `/historial/paciente/{idPaciente}` | Buscar historiales por ID de paciente |
| Historial | DELETE | `/historial/{id}` | Eliminar un historial por ID |
| Especialidad | GET | `/especialidad` | Listar todas las especialidades |
| Especialidad | PUT | `/especialidad` | Actualizar una especialidad |
| Especialidad | POST | `/especialidad` | Registrar una especialidad |
| Especialidad | DELETE | `/especialidad/{id}` | Eliminar una especialidad por ID |
| Cita | GET | `/cita` | Listar todas las citas |
| Cita | PUT | `/cita` | Actualizar una cita |
| Cita | POST | `/cita` | Registrar una cita |
| Cita | GET | `/cita/usuario-medico/{idUsuario}` | Buscar citas por ID de usuario médico |
| Cita | GET | `/cita/paciente/{idPaciente}` | Buscar citas por ID de paciente |
| Cita | DELETE | `/cita/{id}` | Eliminar/Cancelar una cita por ID |






### En Windows

```bash
mvnw.cmd spring-boot:run
```

### En Linux

Primero se debe otorgar permiso de ejecución al archivo Maven Wrapper:

```bash
chmod +x mvnw
```

Después se ejecuta el proyecto:

```bash
./mvnw spring-boot:run
```

También puede ejecutarse directamente desde IntelliJ IDEA abriendo la clase:


## DOCUMENTACIÓN CON SWAGGER

Cuando la aplicación esté ejecutándose, Swagger UI estará disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```
