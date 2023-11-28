package com.pandmuerto.petcitas.repository;

import com.pandmuerto.petcitas.model.entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {
    List<Historial> findByClienteUsername(String username);
    List<Historial> findByMascotaId(int id);
    List<Historial> findByClienteVeterinariaId(int id);
}
