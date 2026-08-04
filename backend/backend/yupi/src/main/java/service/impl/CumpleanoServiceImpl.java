package service.impl;

import model.dto.Cumpleano.CumpleanoRequest;
import model.dto.Cumpleano.CumpleanoResponse;
import model.entity.Cumpleano;
import model.mapper.CumpleanoMapper;
import org.springframework.stereotype.Service;
import repository.CumpleanoRepository;
import service.CumpleanoService;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

@Service
public class CumpleanoServiceImpl implements CumpleanoService {

    private CumpleanoRepository cumpleanoRepository;
    private CumpleanoMapper cumpleanoMapper;

    @Override
    public CumpleanoResponse registrarCumpleano(CumpleanoRequest cumpleanoRequest) {
        if (cumpleanoRequest == null) {
            throw new IllegalArgumentException("EL ID DEL CUMPLEAÑO NO PUEDE SER NULO");
        }
        if (cumpleanoRequest.getFechaEvento() == null || cumpleanoRequest.getFechaEvento().isBefore(ChronoLocalDate.from(LocalDateTime.now()))){
            throw new IllegalArgumentException("LA FECHA DEL CUMPLEAÑOS NO PUEDE SER ANTERIOR A LA ACTUAL");
        }
        Cumpleano cumpleano = cumpleanoMapper.toEntity(cumpleanoRequest);
        Cumpleano cumpleanoGuardado = cumpleanoRepository.save(cumpleano);
        return cumpleanoMapper.toResponse(cumpleanoGuardado);
    }

    @Override
    public CumpleanoResponse consultarCumpleano(Integer id, CumpleanoRequest cumpleanoRequest) {
        if (id == null) {
            throw new IllegalArgumentException("EL ID DEL CUMPLEAÑO NO PUEDE SER NULO");
        }
        Cumpleano cumpleanoId = cumpleanoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NO EXISTE CUMPLEAÑO CON ID:" + id));
        return cumpleanoMapper.toResponse(cumpleanoId);
    }

    @Override
    public CumpleanoResponse consultarCumpleanoPorCliente(Integer idCliente) {
        if( idCliente == null) {
            throw  new IllegalArgumentException("EL ID DEL CLIENTE NO PUEDE SER NULO");
        }
        Cumpleano cumpleano = cumpleanoRepository.findByClienteId(idCliente);
        if(cumpleano == null){
            throw new IllegalArgumentException("NO EXISTEN CLIENTES ASOCIADOS AL CUNPLEAÑO CON ID" + idCliente);
        }
        return cumpleanoMapper.toResponse(cumpleano);
    }

    public void eliminarCumpleano(Integer id) {
        if( id == null){
            throw new IllegalArgumentException("EL ID NO PUEDE SER NULO");
        }

        Cumpleano cumpleano = cumpleanoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NO EXISTE CUMPLEANO CON ID"+ id));
         cumpleanoRepository.delete(cumpleano);
    }
}
