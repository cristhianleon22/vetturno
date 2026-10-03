package com.devsenior.VetTurno.repository;

import com.devsenior.VetTurno.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByVeterinarioIdAndFechaHoraBetween(Long veterinarioId, LocalDateTime desde, LocalDateTime hasta);
    List<Cita> findByVeterinarioId(Long veterinarioId);
}
