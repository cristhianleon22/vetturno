package com.devsenior.VetTurno.dto;

public record VeterinarioRequest(
    String nombre,
    String apellido,
    String especialidad,
    String telefono
) {}
