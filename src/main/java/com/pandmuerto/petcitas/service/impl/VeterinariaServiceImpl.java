package com.pandmuerto.petcitas.service.impl;

import com.pandmuerto.petcitas.model.entity.Veterinaria;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.repository.IVeterinariaRepository;
import com.pandmuerto.petcitas.service.IVeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinariaServiceImpl implements IVeterinariaService {

    @Autowired
    private IVeterinariaRepository veterinariaRepository;

    @Override
    public GenericFlow registrarVeterinaria(GenericFlow genericFlow) {
        Veterinaria response = veterinariaRepository.save((Veterinaria) genericFlow.getRequest());
        if(response.getId()!=0){
            genericFlow.setResponse(response);
            genericFlow.setStatus("OK");
            genericFlow.setMessage("Registro Exitoso");
            genericFlow.setCode("200");
        }
        return genericFlow;
    }

    @Override
    public GenericFlow obtenerVeterinaria(GenericFlow genericFlow) {
        Veterinaria request = (Veterinaria) genericFlow.getRequest();
        Veterinaria response = veterinariaRepository.findByNombre(request.getNombre());
        genericFlow.setResponse(response);
        if(response!=null){
            genericFlow.setCode("200");
            genericFlow.setStatus("OK");
            genericFlow.setMessage("Veterinaria Encontrada");
        }else{
            genericFlow.setCode("404");
            genericFlow.setStatus("ERROR");
            genericFlow.setMessage("Veterinaria no Encontrada");
        }
        return genericFlow;
    }
}
