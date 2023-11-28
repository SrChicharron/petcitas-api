package com.pandmuerto.petcitas.repository;

import com.pandmuerto.petcitas.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByVeterinariaId(Integer id);

    Producto findByNombreAndVeterinariaId(String nombre, int id);
}
