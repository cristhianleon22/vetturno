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
        veterinario.setEspecialidad(request.especialidad());
        
        Veterinario saved = veterinarioRepository.save(veterinario);
        
        return new VeterinarioDTO(saved.getId(), saved.getNombre(), saved.getEspecialidad());
    }

    public List<VeterinarioDTO> getAllVeterinarios() {
        return veterinarioRepository.findAll().stream()
                .map(v -> new VeterinarioDTO(v.getId(), v.getNombre(), v.getEspecialidad()))
                .collect(Collectors.toList());
    }
}
