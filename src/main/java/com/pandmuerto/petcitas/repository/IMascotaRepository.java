package com.pandmuerto.petcitas.repository;

import com.pandmuerto.petcitas.model.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {

    Mascota findById(int id);
    Mascota findByNombre(String nombre);
    Mascota findByNombreAndClienteUsername(String nombre, String username);
    List<Mascota> findAll();
    List<Mascota> findByClienteUsername(String username);
}
