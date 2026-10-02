package com.devsenior.VetTurno.dto;

public record VeterinarioDTO(
    Long id,
    String nombre,
    String apellido,
    String especialidad,
    String telefono
) {}
