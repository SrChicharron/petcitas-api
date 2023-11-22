package com.pandmuerto.petcitas.service.impl;

import com.pandmuerto.petcitas.model.entity.Usuario;
import com.pandmuerto.petcitas.model.entity.Veterinaria;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.repository.IUsuarioRepository;
import com.pandmuerto.petcitas.repository.IVeterinariaRepository;
import com.pandmuerto.petcitas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IVeterinariaRepository veterinariaRepository;

    @Override
    public GenericFlow registrarUsuario(GenericFlow flow) {
        Usuario response = new Usuario();
        Usuario request = (Usuario) flow.getRequest();
        Veterinaria veterinaria = null;
        response = usuarioRepository.findByUsername(request.getUsername());
        if(response!=null){
            flow.setStatus("ERROR");
            flow.setMessage("Usuario ya existe");
            flow.setCode("409");
            return flow;
        }
        response = usuarioRepository.findByEmail(request.getEmail());
        if (response!=null){
            flow.setStatus("ERROR");
            flow.setMessage("Email ya existe");
            flow.setCode("409");
            return flow;
        }
        if(request.getRol().equals("CLIENTE")){
            veterinaria= veterinariaRepository.findById(request.getVeterinaria().getId());
            if(veterinaria==null){
                flow.setStatus("ERROR");
                flow.setMessage("Veterinaria no existe");
                flow.setCode("409");
                return flow;
            }
        }
        else if(request.getRol().equals("ADMINISTRADOR")){
            veterinaria=veterinariaRepository.save(request.getVeterinaria());
            if(veterinaria==null){
                flow.setStatus("ERROR");
                flow.setMessage("No se pudo registrar la Veterinaria");
                flow.setCode("409");
                return flow;
            }else {
                request.setVeterinaria(veterinaria);
            }
        }
        response = usuarioRepository.save(request);
        if(response==null){
            flow.setStatus("ERROR");
            flow.setMessage("No se pudo registrar el Usuario");
            flow.setCode("409");
            return flow;
        }
        flow.setStatus("OK");
        flow.setResponse(response);
        flow.setMessage("Usuario Registrado");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow actualizarUsuario(GenericFlow flow) {
        return null;
    }

    @Override
    public GenericFlow eliminarUsuario(GenericFlow flow) {
        return null;
    }

    @Override
    public GenericFlow obtenerUsuario(GenericFlow flow) {
        return null;
    }

    @Override
    public GenericFlow obtenerUsuarios(GenericFlow flow) {
        return null;
    }

    @Override
    public GenericFlow Login(GenericFlow flow) {
        Usuario request = (Usuario) flow.getRequest();
        Usuario response = usuarioRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if(response==null){
            response=usuarioRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
            if(response==null){
                flow.setStatus("ERROR");
                flow.setMessage("Datos de acceso incorrectos");
                flow.setCode("401");
                return flow;
            }
        }
        flow.setStatus("OK");
        flow.setCode("200");
        flow.setResponse(response);
        flow.setMessage("Usuario logueado");
        return flow;
    }
}
