package com.pandmuerto.petcitas.service;

import com.pandmuerto.petcitas.model.flow.GenericFlow;

public interface IUsuarioService {

    GenericFlow registrarUsuario(GenericFlow flow);

    GenericFlow actualizarUsuario(GenericFlow flow);

    GenericFlow eliminarUsuario(GenericFlow flow);

    GenericFlow obtenerUsuario(GenericFlow flow);

    GenericFlow obtenerUsuarios(GenericFlow flow);

    GenericFlow Login(GenericFlow flow);

}
