package com.pandmuerto.petcitas.controller;

import com.pandmuerto.petcitas.model.entity.Veterinaria;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.service.IVeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petcitas/veterinaria")
public class VeterinariaController {

    @Autowired
    IVeterinariaService veterinariaService;

    @PostMapping("/add")
    public ResponseEntity<?> registrarVeterinaria(@RequestBody Veterinaria veterinaria){
        GenericFlow response = new GenericFlow();
        response.setRequest(veterinaria);
        response = veterinariaService.registrarVeterinaria(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/get")
    public ResponseEntity<?> getVeterinaria(@RequestBody Veterinaria veterinaria){
        GenericFlow response = new GenericFlow();
        response.setRequest(veterinaria);
        response = veterinariaService.obtenerVeterinaria(response);
        return ResponseEntity.ok(response);
    }
}
