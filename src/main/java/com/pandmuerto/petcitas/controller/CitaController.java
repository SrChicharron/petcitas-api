package com.pandmuerto.petcitas.controller;

import com.pandmuerto.petcitas.model.entity.Cita;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petcitas/cita")
public class CitaController {
    @Autowired
    ICitaService citaService;

    @PostMapping("/add")
    public ResponseEntity<?> registrarCita(@RequestBody Cita cita){
        GenericFlow response = new GenericFlow();
        response.setRequest(cita);
        response = citaService.crearCita(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obtenerCitas")
    public ResponseEntity<?> obtenerCitas(@RequestBody Cita cita){
        GenericFlow response = new GenericFlow();
        response.setRequest(cita);
        response = citaService.obtenerCitas(response);
        return ResponseEntity.ok(response);
    }
}
