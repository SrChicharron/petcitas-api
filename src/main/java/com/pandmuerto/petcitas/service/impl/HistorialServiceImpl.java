package com.pandmuerto.petcitas.service.impl;

import com.pandmuerto.petcitas.model.entity.Historial;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.repository.IHistorialRepository;
import com.pandmuerto.petcitas.service.IHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialServiceImpl implements IHistorialService {

    @Autowired
    private IHistorialRepository historialRepository;
    @Override
    public GenericFlow agregarHistorial(GenericFlow flow) {
        Historial request = (Historial) flow.getRequest();
        Historial response = historialRepository.save(request);
        flow.setResponse(response);
        flow.setMessage("Historial creado correctamente");
        flow.setStatus("200");
        flow.setStatus("OK");
        return flow;
    }

    @Override
    public GenericFlow actualizarHistorial(GenericFlow flow) {
        Historial request = (Historial) flow.getRequest();
        Historial response = historialRepository.save(request);
        flow.setResponse(response);
        flow.setMessage("Historial actualizado correctamente");
        flow.setCode("200");
        flow.setStatus("OK");
        return flow;
    }

    @Override
    public GenericFlow eliminarHistorial(GenericFlow flow) {
        Historial request = (Historial) flow.getRequest();
        historialRepository.delete(request);
        flow.setMessage("Historial eliminado correctamente");
        flow.setCode("200");
        flow.setStatus("OK");
        return flow;
    }

    @Override
    public GenericFlow obtenerHistorialVeterinaria(GenericFlow flow) {
        Historial request = (Historial) flow.getRequest();
        List<Serializable> responses = new ArrayList<>();
        List<Historial> historiales = historialRepository.findByClienteVeterinariaId(
                request.getCliente().getVeterinaria().getId());
        responses.addAll(historiales);
        /**Validacion de responses**/
        if(responses.size()==0){
            flow.setMessage("No se encontraron historiales");
            flow.setCode("404");
            flow.setStatus("Error");
        }else{
            flow.setCode("200");
            flow.setStatus("OK");
            flow.setMessage(responses.size()+ " Historiales encontrado");
            flow.setResponses(responses);
        }
        return flow;
    }

    @Override
    public GenericFlow obtenerHistorialCliente(GenericFlow flow) {
        Historial request = (Historial) flow.getRequest();
        List<Serializable> responses = new ArrayList<>();
        List<Historial> historiales = historialRepository.findByClienteUsername(
                request.getCliente().getUsername());
        responses.addAll(historiales);
        /**Validacion de responses**/
        if(responses.size()==0){
            flow.setMessage("No se encontraron historiales");
            flow.setCode("404");
            flow.setStatus("Error");
        }else{
            flow.setCode("200");
            flow.setStatus("OK");
            flow.setMessage(responses.size()+ " Historiales encontrado");
            flow.setResponses(responses);
        }
        return flow;
    }

    @Override
    public GenericFlow obtenerHistorialMascota(GenericFlow flow) {
        Historial request = (Historial) flow.getRequest();
        List<Serializable> responses = new ArrayList<>();
        List<Historial> historiales = historialRepository.findByMascotaId(
                request.getMascota().getId());
        responses.addAll(historiales);
        /**Validacion de responses**/
        if(responses.size()==0){
            flow.setMessage("No se encontraron historiales");
            flow.setCode("404");
            flow.setStatus("Error");
        }else{
            flow.setCode("200");
            flow.setStatus("OK");
            flow.setMessage(responses.size()+ " Historiales encontrado");
            flow.setResponses(responses);
        }
        return flow;
    }
}
