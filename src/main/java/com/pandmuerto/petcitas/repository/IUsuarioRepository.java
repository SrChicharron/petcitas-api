package com.pandmuerto.petcitas.repository;

import com.pandmuerto.petcitas.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByEmailAndPassword(String email, String password);
    Usuario findByUsername(String username);
    Usuario findByUsernameAndPassword(String username, String password);
    List<Usuario> findByRolAndVeterinariaId(String rol, int id);
}
