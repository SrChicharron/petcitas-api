package com.pandmuerto.petcitas.service;

import com.pandmuerto.petcitas.model.flow.GenericFlow;

public interface IProductoService {
    GenericFlow agregarProducto(GenericFlow flow);

    GenericFlow obtenerProductos(GenericFlow flow);

    GenericFlow actualizarProducto(GenericFlow flow);

    GenericFlow eliminarProducto(GenericFlow flow);

}
