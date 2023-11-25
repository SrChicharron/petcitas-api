package com.pandmuerto.petcitas.service;

import com.pandmuerto.petcitas.model.flow.GenericFlow;

public interface IMascotaService {
    GenericFlow registrarMascota(GenericFlow flow);

    GenericFlow actualizarMascota(GenericFlow flow);

    GenericFlow eliminarMascota(GenericFlow flow);

    GenericFlow obtenerMascota(GenericFlow flow);

    GenericFlow obtenerMascotas(GenericFlow flow);

    GenericFlow obtenerMascotasPorCliente(GenericFlow flow);

    GenericFlow obtenerMascotaPorNombreYCliente(GenericFlow flow);
}
