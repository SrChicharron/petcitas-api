package com.pandmuerto.petcitas.controller;

import com.pandmuerto.petcitas.model.entity.Mascota;
import com.pandmuerto.petcitas.model.entity.Usuario;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petcitas/mascota")
public class MascotaController {
    @Autowired
    IMascotaService mascotaService;

    @PostMapping("/add")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota mascota){
        GenericFlow response = new GenericFlow();
        response.setRequest(mascota);
        response = mascotaService.registrarMascota(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/mascotasPorCliente")
    public ResponseEntity<?> mascotasPorCliente(@RequestBody Usuario usuario){
        GenericFlow response = new GenericFlow();
        response.setRequest(usuario);
        response = mascotaService.obtenerMascotasPorCliente(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/mascotasPorVeterinaria")
    public ResponseEntity<?> mascotasPorVeterinaroa(@RequestBody Usuario usuario){
        GenericFlow response = new GenericFlow();
        response.setRequest(usuario);
        response = mascotaService.obtenerMascotas(response);
        return ResponseEntity.ok(response);
    }
}
