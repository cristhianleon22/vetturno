package com.devsenior.VetTurno.service;

import com.devsenior.VetTurno.dto.PropietarioDTO;
import com.devsenior.VetTurno.dto.PropietarioRequest;
import com.devsenior.VetTurno.model.Propietario;
import com.devsenior.VetTurno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public PropietarioDTO createPropietario(PropietarioRequest request) {
        Propietario propietario = new Propietario();
        propietario.setNombre(request.getNombre());
        propietario.setApellido(request.getApellido());
        propietario.setTelefono(request.getTelefono());
        propietario.setEmail(request.getEmail());
        
        Propietario saved = propietarioRepository.save(propietario);
        
        return new PropietarioDTO(saved.getId(), saved.getNombre(), saved.getApellido(), saved.getTelefono(), saved.getEmail());
    }

    public List<PropietarioDTO> getAllPropietarios() {
        return propietarioRepository.findAll().stream()
                .map(p -> new PropietarioDTO(p.getId(), p.getNombre(), p.getApellido(), p.getTelefono(), p.getEmail()))
                .collect(Collectors.toList());
    }
}
