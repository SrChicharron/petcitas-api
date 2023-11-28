package com.pandmuerto.petcitas.controller;

import com.pandmuerto.petcitas.model.entity.Historial;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.service.IHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petcitas/historial")
public class HistorialController {
    @Autowired
    private IHistorialService historialService;

    @PostMapping("/add")
    public ResponseEntity<?> registrarHistorial(@RequestBody Historial request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = historialService.agregarHistorial(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarHistorial(@RequestBody Historial request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = historialService.actualizarHistorial(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/eliminar")
    public ResponseEntity<?> eliminarHistorial(@RequestBody Historial request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = historialService.eliminarHistorial(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obtenerVeterinaria")
    public ResponseEntity<?> obtenerHistorialVeterinaria(@RequestBody Historial request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = historialService.obtenerHistorialVeterinaria(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obtenerCliente")
    public ResponseEntity<?> obtenerHistorialCliente(@RequestBody Historial request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = historialService.obtenerHistorialCliente(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obtenerMascota")
    public ResponseEntity<?> obtenerHistorialMascota(@RequestBody Historial request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = historialService.obtenerHistorialMascota(response);
        return ResponseEntity.ok(response);
    }

}
