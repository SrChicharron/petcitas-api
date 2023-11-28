package com.pandmuerto.petcitas.controller;

import com.pandmuerto.petcitas.model.entity.Producto;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petcitas/producto")
public class ProductoController {
    private @Autowired
    IProductoService productoService;
    @PostMapping("/add")
    public ResponseEntity<?> registrarProducto(@RequestBody Producto request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = productoService.agregarProducto(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = productoService.actualizarProducto(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/eliminar")
    public ResponseEntity<?> eliminarProducto(@RequestBody Producto request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = productoService.eliminarProducto(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/obtener")
    public ResponseEntity<?> obtenerProductos(@RequestBody Producto request){
        GenericFlow response = new GenericFlow();
        response.setRequest(request);
        response = productoService.obtenerProductos(response);
        return ResponseEntity.ok(response);
    }
}
