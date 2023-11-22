package com.pandmuerto.petcitas.service;

import com.pandmuerto.petcitas.model.flow.GenericFlow;

public interface IVeterinariaService {

    GenericFlow registrarVeterinaria(GenericFlow genericFlow);

    GenericFlow obtenerVeterinaria(GenericFlow genericFlow);
}
