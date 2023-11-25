package com.pandmuerto.petcitas.repository;

import com.pandmuerto.petcitas.model.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByVeterinariaIdAndFechaGreaterThanEqual(Integer id, String fecha);
}
