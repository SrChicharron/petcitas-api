package com.pandmuerto.petcitas.service.impl;

import com.pandmuerto.petcitas.model.entity.Cita;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.repository.ICitaRepository;
import com.pandmuerto.petcitas.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    ICitaRepository citaRepository;

    @Override
    public GenericFlow crearCita(GenericFlow flow) {
        Cita request = (Cita) flow.getRequest();
        Cita response = citaRepository.save(request);
        flow.setResponse(response);
        flow.setMessage("Cita creada");
        flow.setStatus("OK");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow obtenerCitas(GenericFlow flow) {
        Cita request = (Cita) flow.getRequest();
        List<Cita> citas = citaRepository.findByVeterinariaIdAndFechaGreaterThanEqual(request.getVeterinaria().getId(), request.getFecha());
        if(citas.isEmpty()){
            flow.setStatus("ERROR");
            flow.setMessage("No hay citas registradas");
            flow.setCode("404");
            return flow;
        }
        List<Serializable> responses = new ArrayList<>();
        responses.addAll(citas);
        flow.setResponses(responses);
        flow.setStatus("OK");
        flow.setMessage(responses.size()+" Citas encontradas");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow eliminarCita(GenericFlow flow) {
        Cita request = (Cita) flow.getRequest();
        citaRepository.deleteById(request.getId());
        Cita response = citaRepository.findById(request.getId()).orElse(null);
        if(response == null){
            flow.setStatus("OK");
            flow.setMessage("Cita eliminada");
            flow.setCode("200");
        }else {
            flow.setStatus("ERROR");
            flow.setMessage("Error al eliminar la cita");
            flow.setCode("404");
        }
        return flow;
    }

    @Override
    public GenericFlow actualizarCita(GenericFlow flow) {
        Cita request = (Cita) flow.getRequest();
        Cita response = citaRepository.save(request);
        flow.setResponse(response);
        flow.setMessage("Cita actualizada");
        flow.setStatus("OK");
        flow.setCode("200");
        return flow;
    }
}
