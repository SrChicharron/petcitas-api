package com.pandmuerto.petcitas.controller;

import com.pandmuerto.petcitas.model.entity.Usuario;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petcitas/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    @PostMapping("/add")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario){
        GenericFlow response = new GenericFlow();
        response.setRequest(usuario);
        response = usuarioService.registrarUsuario(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        GenericFlow response = new GenericFlow();
        response.setRequest(usuario);
        response = usuarioService.Login(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obtenerUsuarios")
    public ResponseEntity<?> obtenerUsuarios(@RequestBody Usuario usuario){
        GenericFlow response = new GenericFlow();
        response.setRequest(usuario);
        response = usuarioService.obtenerUsuarios(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/eliminar")
    public ResponseEntity<?> eliminarUsuario(@RequestBody Usuario usuario){
        GenericFlow response = new GenericFlow();
        response.setRequest(usuario);
        response = usuarioService.eliminarUsuario(response);
        return ResponseEntity.ok(response);
    }
}
