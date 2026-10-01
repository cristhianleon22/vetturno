package com.devsenior.VetTurno.controller;

import com.devsenior.VetTurno.dto.PropietarioDTO;
import com.devsenior.VetTurno.dto.PropietarioRequest;
import com.devsenior.VetTurno.service.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping
    public ResponseEntity<PropietarioDTO> createPropietario(@RequestBody PropietarioRequest request) {
        PropietarioDTO created = propietarioService.createPropietario(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropietarioDTO>> getAllPropietarios() {
        List<PropietarioDTO> propietarios = propietarioService.getAllPropietarios();
        return ResponseEntity.ok(propietarios);
    }
}
