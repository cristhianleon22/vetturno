# VetTurno
La agenda digital de Veterinaria Huellitas.

## Historia y Propósito
Doña Marta abrió Veterinaria Huellitas hace seis años. Hoy en día, la clínica cuenta con la ayuda del doctor Andrés y de Paula en recepción. Debido a que la agenda todavía vive entre un cuaderno y conversaciones de WhatsApp, la información está dispersa y a veces ocurren cruces de horarios o pérdida de datos

El propósito de VetTurno es proveer una API que permita:
* Registrar responsables, mascotas y veterinarios
* Agendar citas evitando cruces de horario para el mismo veterinario
* Consultar la agenda con información clara y persistente

## Tecnologías Utilizadas
* Java 17
* Spring Boot
* Maven
* MySQL
* JPA / Hibernate
* Swagger / OpenAPI
* JWT

## Cómo ejecutar
1. **Base de datos:** Crea una base de datos vacía en MySQL llamada `vetturno`.
2. **Configuración:** Configura la conexión local abriendo el archivo `application.properties` y colocando tus credenciales de MySQL.
3. **Despliegue:** Ejecuta la clase principal `VetTurnoApplication.java` para iniciar el servidor embebido.