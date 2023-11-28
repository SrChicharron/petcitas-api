package com.pandmuerto.petcitas.service;

import com.pandmuerto.petcitas.model.flow.GenericFlow;

public interface IHistorialService {
    GenericFlow agregarHistorial(GenericFlow flow);
    GenericFlow actualizarHistorial(GenericFlow flow);
    GenericFlow eliminarHistorial(GenericFlow flow);
    GenericFlow obtenerHistorialVeterinaria(GenericFlow flow);
    GenericFlow obtenerHistorialCliente(GenericFlow flow);
    GenericFlow obtenerHistorialMascota(GenericFlow flow);
}
