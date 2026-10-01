package com.devsenior.VetTurno.controller;

import com.devsenior.VetTurno.dto.VeterinarioDTO;
import com.devsenior.VetTurno.dto.VeterinarioRequest;
import com.devsenior.VetTurno.service.VeterinarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @PostMapping
    public ResponseEntity<VeterinarioDTO> createVeterinario(@RequestBody VeterinarioRequest request) {
        VeterinarioDTO created = veterinarioService.createVeterinario(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> getAllVeterinarios() {
        List<VeterinarioDTO> veterinarios = veterinarioService.getAllVeterinarios();
        return ResponseEntity.ok(veterinarios);
    }
}
