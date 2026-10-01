package com.devsenior.VetTurno.dto;

public record MascotaDTO(
    Long id,
    String nombre,
    String especie,
    String raza,
    Long propietarioId,
    String propietarioNombre
) {}
