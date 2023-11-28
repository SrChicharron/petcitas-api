package com.pandmuerto.petcitas.service;

import com.pandmuerto.petcitas.model.flow.GenericFlow;

public interface ICitaService {
    GenericFlow crearCita(GenericFlow flow);

    GenericFlow obtenerCitas(GenericFlow flow);

    GenericFlow eliminarCita(GenericFlow flow);

    GenericFlow actualizarCita(GenericFlow flow);
}
