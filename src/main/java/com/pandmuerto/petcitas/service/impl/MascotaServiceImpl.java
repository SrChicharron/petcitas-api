package com.pandmuerto.petcitas.service.impl;

import com.pandmuerto.petcitas.model.entity.Mascota;
import com.pandmuerto.petcitas.model.entity.Usuario;
import com.pandmuerto.petcitas.model.flow.GenericFlow;
import com.pandmuerto.petcitas.repository.IMascotaRepository;
import com.pandmuerto.petcitas.service.IMascotaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    IMascotaRepository mascotaRepository;
    @Override
    public GenericFlow registrarMascota(GenericFlow flow) {
        Mascota request = (Mascota) flow.getRequest();
        Mascota existe = mascotaRepository.findByNombreAndClienteUsername(request.getNombre(),
                request.getCliente().getUsername());
        if(existe != null){
            flow.setStatus("ERROR");
            flow.setMessage("Mascota Ya registrada");
            flow.setCode("401");
            return flow;
        }
        Mascota mascota = mascotaRepository.save(request);
        flow.setResponse(mascota);
        flow.setStatus("OK");
        flow.setMessage("Mascota Registrada");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow actualizarMascota(GenericFlow flow) {
        Mascota request = (Mascota) flow.getRequest();
        Mascota mascota = mascotaRepository.save(request);
        flow.setResponse(mascota);
        flow.setStatus("OK");
        flow.setMessage("Informacion de Mascota Actualizada");
        flow.setCode("200");
        return flow;
    }

    @Transactional
    @Override
    public GenericFlow eliminarMascota(GenericFlow flow) {
        Mascota request = (Mascota) flow.getRequest();
        mascotaRepository.deleteById(request.getId());
        Mascota response = mascotaRepository.findById(request.getId());
        if(response == null){
            flow.setStatus("OK");
            flow.setMessage("Mascota eliminada");
            flow.setCode("200");
            return flow;
        }
        flow.setStatus("ERROR");
        flow.setMessage("Error al eliminar mascota");
        flow.setCode("409");
        flow.setResponse(response);
        return flow;
    }

    @Override
    public GenericFlow obtenerMascota(GenericFlow flow) {
        return flow;
    }

    @Override
    public GenericFlow obtenerMascotas(GenericFlow flow) {
        Usuario request = (Usuario) flow.getRequest();
        List<Serializable> responses = new ArrayList<>();
        List<Mascota> mascotas = mascotaRepository.findByClienteVeterinariaId(
                request.getVeterinaria().getId());
        if(mascotas.isEmpty()){
            flow.setStatus("ERROR");
            flow.setMessage("No hay mascotas registradas");
            flow.setCode("404");
            return flow;
        }
        responses.addAll(mascotas);
        flow.setResponses(responses);
        flow.setStatus("OK");
        flow.setMessage(mascotas.size() +" Mascotas encontradas");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow obtenerMascotasPorCliente(GenericFlow flow) {
        Usuario request = (Usuario) flow.getRequest();
        List<Mascota> mascotas = mascotaRepository.findByClienteUsername(request.getUsername());
        if(mascotas.isEmpty()){
            flow.setStatus("ERROR");
            flow.setMessage("No hay mascotas registradas");
            flow.setCode("404");
            return flow;
        }
        List<Serializable> responses= new ArrayList<>();
        responses.addAll(mascotas);
        flow.setResponses(responses);
        flow.setStatus("OK");
        flow.setMessage(mascotas.size() +" Mascotas encontradas");
        flow.setCode("200");
        return flow;
    }

    @Override
    public GenericFlow obtenerMascotaPorNombreYCliente(GenericFlow flow) {
        return flow;
    }
}
