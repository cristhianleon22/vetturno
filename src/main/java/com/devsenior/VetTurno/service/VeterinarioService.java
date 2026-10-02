package com.devsenior.VetTurno.service;

import com.devsenior.VetTurno.dto.VeterinarioDTO;
import com.devsenior.VetTurno.dto.VeterinarioRequest;
import com.devsenior.VetTurno.model.Veterinario;
import com.devsenior.VetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public VeterinarioDTO createVeterinario(VeterinarioRequest request) {
        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(request.nombre());
        veterinario.setApellido(request.apellido());
        veterinario.setEspecialidad(request.especialidad());
        veterinario.setTelefono(request.telefono());
        
        Veterinario saved = veterinarioRepository.save(veterinario);
        
        return new VeterinarioDTO(saved.getId(), saved.getNombre(), saved.getApellido(), saved.getEspecialidad(), saved.getTelefono());
    }

    public List<VeterinarioDTO> getAllVeterinarios() {
        return veterinarioRepository.findAll().stream()
                .map(v -> new VeterinarioDTO(v.getId(), v.getNombre(), v.getApellido(), v.getEspecialidad(), v.getTelefono()))
                .collect(Collectors.toList());
    }
}
