package com.pandmuerto.petcitas.repository;

import com.pandmuerto.petcitas.model.entity.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeterinariaRepository extends JpaRepository<Veterinaria, Integer> {
    Veterinaria findByNombre(String nombre);
    Veterinaria findById(int id);
}
