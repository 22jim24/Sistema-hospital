

<p align="center">
  <img
    src="./imagenes/presentacion.png.png"
    alt="Imagen de presentación del Sistema de Facturación"
    width="300">
</p>

<p align="center">

  <a href="https://www.java.com/" target="_blank">
    <img
      src="https://1000logos.net/wp-content/uploads/2020/09/Java-Logo.png"
      alt="Java 17"
      width="70">
  </a>

  &nbsp;&nbsp;&nbsp;

  <a href="https://spring.io/projects/spring-boot" target="_blank">
    <img
      src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/960px-Spring_Framework_Logo_2018.svg.png"
      alt="Spring Boot"
      width="120">
  </a>

  &nbsp;&nbsp;&nbsp;

  <a href="https://www.mysql.com/" target="_blank">
    <img
      src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original.svg"
      alt="MySQL"
      width="70">
  </a>

  &nbsp;&nbsp;&nbsp;

  <a href="https://www.postman.com/" target="_blank">
    <img
      src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg"
      alt="Postman"
      width="70">
  </a>

</p>


# Sistema de Clínica - API REST

## Descripción del Proyecto
Desarrollamos una API REST para la gestión integral de una clínica u hospital, abarcando el control de citas, médicos, pacientes, especialidades, sedes, turnos, historiales médicos, roles y usuarios con autenticación mediante JWT (JSON Web Token) y Spring Security.

La aplicación permite registrar, listar, buscar, actualizar y eliminar información a través de solicitudes HTTP utilizando una base de datos MySQL (`clinica_DB`).



## INTEGRANTES

- JIMMY NARAZAS
- ANDRES UGARTE
- Mirella zevallos
- Hector Llocce

  
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

| Módulo | Método | Endpoint | Función |
|---|---|---|---|
| Usuario | POST | `/usuario` | Registrar un usuario |
| Usuario | GET | `/usuario` | Listar todos los usuarios |
| Usuario | POST | `/usuario/login` | Iniciar sesión y generar token JWT |
| Usuario | PUT | `/usuario` | Actualizar un usuario |
| Usuario | DELETE | `/usuario/{id}` | Eliminar un usuario por ID |
| Turno | POST | `/turno` | Registrar un turno |
| Turno | GET | `/turno` | Listar todos los turnos |
| Turno | PUT | `/turno` | Actualizar un turno |
| Turno | DELETE | `/turno/{id}` | Eliminar un turno por ID |
| Sede | POST | `/sede` | Registrar una sede |
| Sede | GET | `/sede` | Listar todas las sedes |
| Sede | PUT | `/sede` | Actualizar una sede |
| Sede | DELETE | `/sede/{id}` | Eliminar una sede por ID |
| Rol | POST | `/rol` | Registrar un rol |
| Rol | GET | `/rol` | Listar todos los roles |
| Rol | PUT | `/rol` | Actualizar un rol |
| Rol | DELETE | `/rol/{id}` | Eliminar un rol por ID |
| Paciente | POST | `/paciente` | Registrar un paciente |
| Paciente | GET | `/paciente` | Listar todos los pacientes |
| Paciente | PUT | `/paciente` | Actualizar un paciente |
| Paciente | DELETE | `/paciente/{id}` | Eliminar un paciente por ID |
| Médico | POST | `/medico` | Registrar un médico |
| Médico | GET | `/medico` | Listar todos los médicos |
| Médico | PUT | `/medico` | Actualizar un médico |
| Médico | DELETE | `/medico/{id}` | Eliminar un médico por ID |
| Historial | POST | `/historial` | Registrar un historial médico |
| Historial | GET | `/historial/paciente/{idPaciente}` | Buscar historiales por ID de paciente |
| Historial | PUT | `/historial` | Actualizar un registro del historial médico |
| Historial | DELETE | `/historial/{id}` | Eliminar un historial por ID |
| Especialidad | POST | `/especialidad` | Registrar una especialidad |
| Especialidad | GET | `/especialidad` | Listar todas las especialidades |
| Especialidad | PUT | `/especialidad` | Actualizar una especialidad |
| Especialidad | DELETE | `/especialidad/{id}` | Eliminar una especialidad por ID |
| Cita | POST | `/cita` | Registrar una cita |
| Cita | GET | `/cita` | Listar todas las citas |
| Cita | GET | `/cita/paciente/{idPaciente}` | Buscar citas por ID de paciente |
| Cita | GET | `/cita/usuario-medico/{idUsuario}` | Buscar citas por ID de usuario médico |
| Cita | PUT | `/cita` | Actualizar una cita |
| Cita | DELETE | `/cita/{id}` | Eliminar/Cancelar una cita por ID |

Funciones Principales por Módulo

Citas: Programación, listado, búsqueda por ID, actualización y cancelación/anulación de citas médicas.

Médicos: Registro, asignación de especialidades, listado y administración del staff médico.

Pacientes: Gestión de datos personales y expediente clínico de los pacientes.

Especialidades: Control de las ramas médicas disponibles en el hospital.

Sedes: Administración de las distintas sucursales o locaciones de la clínica.

Turnos: Configuración de horarios de atención.

Historial Médico: Seguimiento clínico del paciente dentro de la institución.

Seguridad (Usuarios y Roles): Control de accesos mediante Spring Security y generación de tokens JWT.


### API

Una API permite la comunicación entre diferentes aplicaciones, sin importar el lenguaje de programación con el que hayan sido desarrolladas.

### REST

REST es un estilo de arquitectura que establece buenas prácticas para crear servicios web mediante solicitudes HTTP.

### API REST

Una API REST permite que un cliente envíe solicitudes al servidor mediante métodos HTTP. El servidor procesa la solicitud y devuelve una respuesta.

Los métodos HTTP principales utilizados son:

- **GET:** consulta información.
- **POST:** registra nueva información.
- **PUT:** actualiza información existente.
- **DELETE:** elimina información.


## SPRING SECURITY

Spring Security es una herramienta de Spring que permite proteger una aplicación mediante autenticación y autorización.

Puede utilizarse para:

- Solicitar usuario y contraseña.
- Proteger determinados endpoints.
- Asignar roles, como administrador o vendedor.
- Evitar que personas no autorizadas modifiquen o eliminen información.
- Implementar autenticación mediante tokens JWT.


#CREACION BD

CREATE DATABASE clinica_DB;


Actualiza las credenciales de conexión en el archivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/clinica_DB?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña


## EJECUCIÓN DEL PROYECTO

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

```text
SitemaClinicaApplication
```


## DOCUMENTACIÓN CON SWAGGER

Cuando la aplicación esté ejecutándose, Swagger UI estará disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```
