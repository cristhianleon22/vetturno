package com.devsenior.VetTurno.controller;

import com.devsenior.VetTurno.dto.CitaDTO;
import com.devsenior.VetTurno.dto.CitaRequest;
import com.devsenior.VetTurno.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<CitaDTO> agendarCita(@Valid @RequestBody CitaRequest request) {
        CitaDTO response = citaService.agendarCita(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> obtenerTodas() {
        List<CitaDTO> response = citaService.obtenerTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/veterinario/{id}")
    public ResponseEntity<List<CitaDTO>> obtenerPorVeterinario(@PathVariable Long id) {
        List<CitaDTO> response = citaService.obtenerPorVeterinario(id);
        return ResponseEntity.ok(response);
    }
}
