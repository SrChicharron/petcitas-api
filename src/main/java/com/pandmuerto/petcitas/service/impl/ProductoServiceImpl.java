package com.pandmuerto.petcitas.service.impl;

import com.pandmuerto.petcitas.model.entity.Producto;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.repository.IProductoRepository;
import com.pandmuerto.petcitas.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public GenericFlow agregarProducto(GenericFlow flow) {
        Producto request = (Producto) flow.getRequest();
        Producto existe = productoRepository.findByNombreAndVeterinariaId(request.getNombre(),request.getVeterinaria().getId());
        if(existe != null){
            flow.setStatus("ERROR");
            flow.setMessage("Producto ya existe");
            flow.setCode("409");
            return flow;
        }
        Producto producto = productoRepository.save(request);
        flow.setResponse(producto);
        flow.setStatus("OK");
        flow.setMessage("Producto Registrado");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow obtenerProductos(GenericFlow flow) {
        Producto request = (Producto) flow.getRequest();
        List<Serializable> responses= new ArrayList<>();
        List<Producto> productos = productoRepository.findByVeterinariaId(request.getVeterinaria().getId());
        if(productos.isEmpty()){
            flow.setStatus("ERROR");
            flow.setMessage("No hay productos registrados");
            flow.setCode("404");
            return flow;
        }
        responses.addAll(productos);
        flow.setResponses(responses);
        flow.setStatus("OK");
        flow.setMessage(productos.size() +" Productos encontrados");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow actualizarProducto(GenericFlow flow) {
        Producto  request = (Producto) flow.getRequest();
        Producto  producto = productoRepository.save(request);
        flow.setResponse(producto);
        flow.setStatus("OK");
        flow.setMessage("Informacion de Producto Actualizada");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow eliminarProducto(GenericFlow flow) {
        Producto request = (Producto) flow.getRequest();
        productoRepository.deleteById(request.getId());
        Producto response = productoRepository.findById(request.getId()).orElse(null);
        if(response == null){
            flow.setStatus("OK");
            flow.setMessage("Producto eliminado");
            flow.setCode("200");
            return flow;
        }
        flow.setStatus("ERROR");
        flow.setMessage("Error al eliminar producto");
        flow.setCode("409");
        flow.setResponse(response);
        return flow;
    }

}
