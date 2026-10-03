package com.devsenior.VetTurno.controller;

import com.devsenior.VetTurno.dto.MascotaDTO;
import com.devsenior.VetTurno.dto.MascotaRequest;
import com.devsenior.VetTurno.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> createMascota(@RequestBody MascotaRequest request) {
        MascotaDTO created = mascotaService.createMascota(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable Long id) {
        MascotaDTO mascota = mascotaService.getMascotaById(id);
        return ResponseEntity.ok(mascota);
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> getAllMascotas() {
        List<MascotaDTO> mascotas = mascotaService.getAllMascotas();
        return ResponseEntity.ok(mascotas);
    }
}
