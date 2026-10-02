package com.devsenior.VetTurno.service;

import com.devsenior.VetTurno.dto.MascotaDTO;
import com.devsenior.VetTurno.dto.MascotaRequest;
import com.devsenior.VetTurno.model.Mascota;
import com.devsenior.VetTurno.model.Propietario;
import com.devsenior.VetTurno.repository.MascotaRepository;
import com.devsenior.VetTurno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    public MascotaService(MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
    }

    public MascotaDTO createMascota(MascotaRequest request) {
        Propietario propietario = propietarioRepository.findById(request.propietarioId())
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con id " + request.propietarioId()));
                
        Mascota mascota = new Mascota();
        mascota.setNombre(request.nombre());
        mascota.setEspecie(request.especie());
        mascota.setRaza(request.raza());
        mascota.setEdad(request.edad());
        mascota.setPropietario(propietario);
        
        Mascota saved = mascotaRepository.save(mascota);
        
        return new MascotaDTO(
                saved.getId(), 
                saved.getNombre(), 
                saved.getEspecie(), 
                saved.getRaza(), 
                saved.getEdad(), 
                saved.getPropietario().getId(), 
                saved.getPropietario().getNombre()
        );
    }

    public List<MascotaDTO> getAllMascotas() {
        return mascotaRepository.findAll().stream()
                .map(m -> new MascotaDTO(
                        m.getId(), 
                        m.getNombre(), 
                        m.getEspecie(), 
                        m.getRaza(), 
                        m.getEdad(), 
                        m.getPropietario().getId(), 
                        m.getPropietario().getNombre()
                ))
                .collect(Collectors.toList());
    }
}
