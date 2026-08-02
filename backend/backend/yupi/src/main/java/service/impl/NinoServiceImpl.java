package service.impl;

import model.dto.Nino.NinoRequest;
import model.dto.Nino.NinoResponse;
import model.entity.Nino;
import model.mapper.NinoMapper;
import org.springframework.stereotype.Service;
import repository.NinoRepository;
import service.NinoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NinoServiceImpl implements NinoService {

    private NinoRepository ninoRepository;
    private NinoMapper ninoMapper;

    public NinoServiceImpl(NinoRepository ninoRepository) {
        this.ninoRepository = ninoRepository;
    }

    @Override
    public NinoResponse registrarNino(NinoRequest ninoRequest) {
        if ( ninoRequest == null){
            throw new IllegalArgumentException("NO SE PERMITEN DATOS NULOS");
        }
        if(ninoRequest.getNombre() == null  || ninoRequest.getNombre().isEmpty()) {
            throw new IllegalArgumentException("FALTAN DATOS EN EL CAMPO NOMBRE");
        }
        Nino nino = ninoMapper.toEntity(ninoRequest);
        Nino ninoGuardado = ninoRepository.save(nino);
        return ninoMapper.toResponse(ninoGuardado);
    }

    @Override
    public NinoResponse consultarNino(Integer id, NinoResponse ninoResponse) {
        if ( id == null){
            throw new IllegalArgumentException("EL ID DEL NINO NO PUEDE SER NULO");
        }
        Nino ninoId = ninoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe nino con id:" + id));
        return ninoMapper.toResponse(ninoId);
    }

    @Override
    public NinoResponse actualizarNino(Integer id, NinoRequest ninoRequest) {
        if ( id == null) {
            throw new IllegalArgumentException("EL ID DEL NINO NO PUEDE SER NULO");
        }
        if ( ninoRequest == null){
            throw  new IllegalArgumentException("LOS DATOS NO PUEDEN ESTAR VACIOS");
        }
        Nino ninoExistente = ninoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NO EXISTE NINO CON ID" + id));
        if(ninoRequest.getNombre() == null || ninoRequest.getNombre().isEmpty()){
            throw new IllegalArgumentException("EL NOMBRE DEL NINO ES OBLIGATORIO");
        }
        if (ninoRequest.getApellidos() == null || ninoRequest.getApellidos().isEmpty()){
            throw new IllegalArgumentException("EL APELLIDO DEL CLIENTE ES OBLIGATORIO");
        }

        ninoMapper.updateEntityFromRequest(ninoRequest, ninoExistente);
        Nino ninoActualizado = ninoRepository.save(ninoExistente);
        return ninoMapper.toResponse(ninoActualizado);
    }

    @Override
    public void eliminarNino(Integer id) {
        if ( id == null) {
            throw new IllegalArgumentException("EL ID NO PUEDE SER NULO");
        }
        Nino nino = ninoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(" NO EXISTE NINO CON ID" + id));
        ninoRepository.delete(nino);
    }

    @Override
    public NinoResponse consultarNinoporCliente(Integer idCliente) {
        if(idCliente == null){
            throw new IllegalArgumentException("EL ID DEL CLIENTE NO PUEDE SER NULO");
        }
        List<Nino> ninos = ninoRepository.findByClienteId(idCliente);
        if (ninos.isEmpty()){
            throw new IllegalArgumentException("NO EXISTEN NINOS ASOCIADOS AL CLIENTE CON ID:" + idCliente);
        }
        return (NinoResponse) ninos.stream()
                .map(ninoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NinoResponse consultarNinoporCumpleano(Integer idCumpleano) {
        if(idCumpleano == null) {
            throw new IllegalArgumentException("EL ID DEL CUMPLEANO NO PUEDE SER NULO");
        }
        List<Nino> ninos = ninoRepository.findByCumpleanoId(idCumpleano);
        if(ninos.isEmpty()){
            throw new IllegalArgumentException("NO EXISTE NINOS ASOCIADOS AL CUMPLEAÑOS CON ESE ID:" + idCumpleano);
        }
        return (NinoResponse) ninos.stream()
                .map(ninoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
