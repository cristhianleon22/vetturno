package com.devsenior.VetTurno.repository;

import com.devsenior.VetTurno.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByPropietarioNombreIgnoreCase(String nombre);
    List<Mascota> findByPropietarioId(Long propietarioId);
}
