package com.devsenior.VetTurno.dto;

public record MascotaRequest(
    String nombre,
    String especie,
    String raza,
    Integer edad,
    Long propietarioId
) {}
