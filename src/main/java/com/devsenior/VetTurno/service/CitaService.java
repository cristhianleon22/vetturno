package com.devsenior.VetTurno.service;

import com.devsenior.VetTurno.dto.CitaDTO;
import com.devsenior.VetTurno.dto.CitaRequest;
import com.devsenior.VetTurno.exception.ReglaNegocioException;
import com.devsenior.VetTurno.model.Cita;
import com.devsenior.VetTurno.model.Mascota;
import com.devsenior.VetTurno.model.Veterinario;
import com.devsenior.VetTurno.repository.CitaRepository;
import com.devsenior.VetTurno.repository.MascotaRepository;
import com.devsenior.VetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private static final Duration DURACION_CITA = Duration.ofHours(1);

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaService(CitaRepository citaRepository, MascotaRepository mascotaRepository, VeterinarioRepository veterinarioRepository) {
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public CitaDTO agendarCita(CitaRequest request) {
        Mascota mascota = mascotaRepository.findById(request.getMascotaId())
                .orElseThrow(() -> new ReglaNegocioException("Mascota no encontrada"));

        Veterinario veterinario = veterinarioRepository.findById(request.getVeterinarioId())
                .orElseThrow(() -> new ReglaNegocioException("Veterinario no encontrado"));

        if (request.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new ReglaNegocioException("La fecha de la cita debe ser futura");
        }

        LocalDateTime inicio = request.getFechaHora();
        LocalDateTime fin = inicio.plus(DURACION_CITA);

        List<Cita> candidatas = citaRepository.findByVeterinarioIdAndFechaHoraBetween(
                veterinario.getId(), inicio.minus(DURACION_CITA), inicio.plus(DURACION_CITA));

        boolean verificarHoraCita = candidatas.stream().anyMatch(cita ->
                cita.getFechaHora().isBefore(fin)
                        && cita.getFechaHora().plus(DURACION_CITA).isAfter(inicio));

        if (verificarHoraCita) {
            throw new ReglaNegocioException("El veterinario ya tiene una cita en ese horario");
        }

        Cita cita = new Cita();
        cita.setFechaHora(request.getFechaHora());
        cita.setMotivo(request.getMotivo());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);

        Cita savedCita = citaRepository.save(cita);

        return mapToDTO(savedCita);
    }

    public List<CitaDTO> obtenerTodas() {
        return citaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<CitaDTO> obtenerPorVeterinario(Long veterinarioId) {
        return citaRepository.findByVeterinarioId(veterinarioId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CitaDTO mapToDTO(Cita cita) {
        return new CitaDTO(
                cita.getId(),
                cita.getFechaHora(),
                cita.getMotivo(),
                cita.getMascota().getNombre(),
                cita.getMascota().getPropietario().getNombre() + " " + cita.getMascota().getPropietario().getApellido(),
                cita.getVeterinario().getNombre() + " " + cita.getVeterinario().getApellido()
        );
    }
}
