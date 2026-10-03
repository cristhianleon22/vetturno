package com.devsenior.VetTurno.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiError {

    private int estado;
    private String mensaje;
    private Map<String, String> errores;
    private LocalDateTime timestamp;

    public ApiError() {
    }

    public ApiError(int estado, String mensaje, Map<String, String> errores) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.errores = errores;
        this.timestamp = LocalDateTime.now();
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}