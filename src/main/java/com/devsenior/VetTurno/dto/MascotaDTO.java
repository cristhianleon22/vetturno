package com.devsenior.VetTurno.dto;

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Long propietarioId;
    private String propietarioNombre;

    public MascotaDTO() {
    }

    public MascotaDTO(Long id, String nombre, String especie, String raza, Integer edad, Long propietarioId,
                      String propietarioNombre) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.propietarioId = propietarioId;
        this.propietarioNombre = propietarioNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Long getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(Long propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getPropietarioNombre() {
        return propietarioNombre;
    }

    public void setPropietarioNombre(String propietarioNombre) {
        this.propietarioNombre = propietarioNombre;
    }

    @Override
    public String toString() {
        return "MascotaDTO{id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza
                + ", edad=" + edad + ", propietarioId=" + propietarioId
                + ", propietarioNombre=" + propietarioNombre + "}";
    }
}