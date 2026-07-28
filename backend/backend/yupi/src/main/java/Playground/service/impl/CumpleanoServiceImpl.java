package Playground.service.impl;

import Playground.model.dto.Cumpleano.CumpleanoRequest;
import Playground.model.dto.Cumpleano.CumpleanoResponse;
import Playground.model.entity.Cliente;
import Playground.model.entity.Cumpleano;
import Playground.model.entity.Enum.EstadoCumpleano;
import Playground.model.entity.ServicioAdicional;

import Playground.model.mapper.CumpleanoMapper;

import Playground.repository.ClienteRepository;
import Playground.repository.CumpleanoRepository;
import Playground.repository.ServicioAdicionalRepository;

import Playground.service.CumpleanoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CumpleanoServiceImpl implements CumpleanoService {


    private final CumpleanoRepository cumpleanoRepository;

    private final ClienteRepository clienteRepository;

    private final ServicioAdicionalRepository servicioRepository;

    private final CumpleanoMapper mapper;



    @Override
    @Transactional
    public CumpleanoResponse registrar(
            CumpleanoRequest request
    ) {


        Cliente cliente =
                clienteRepository.findById(
                                Long.valueOf(request.getIdCliente())
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Cliente no encontrado"
                                )
                        );


        Cumpleano cumpleano =
                mapper.toEntity(request);


        cumpleano.setCliente(cliente);


        cumpleano.setEstado(
                EstadoCumpleano.Pendiente
        );


        if(request.getServicios() != null){

            List<ServicioAdicional> servicios =
                    servicioRepository.findAllById(
                            request.getServicios()
                    );

            cumpleano.setServicios(servicios);
        }


        Cumpleano guardado =
                cumpleanoRepository.save(cumpleano);


        return mapper.toResponse(guardado);
    }



    @Override
    @Transactional(readOnly = true)
    public List<CumpleanoResponse> listar(){

        return mapper.toResponseList(
                cumpleanoRepository.findAll()
        );
    }



    @Override
    @Transactional(readOnly = true)
    public CumpleanoResponse buscarPorId(
            Integer id
    ){

        Cumpleano cumpleano =
                cumpleanoRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Cumpleano no encontrado"
                                )
                        );


        return mapper.toResponse(cumpleano);
    }



    @Override
    @Transactional
    public CumpleanoResponse actualizar(
            Integer id,
            CumpleanoRequest request
    ){

        Cumpleano cumpleano =
                cumpleanoRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Cumpleano no encontrado"
                                )
                        );


        cumpleano.setFechaEvento(
                request.getFechaEvento()
        );

        cumpleano.setHoraInicio(
                request.getHoraInicio()
        );

        cumpleano.setHoraFin(
                request.getHoraFin()
        );

        cumpleano.setCantidadNinos(
                request.getCantidadNinos()
        );

        cumpleano.setCantidadAdultos(
                request.getCantidadAdultos()
        );

        cumpleano.setObservaciones(
                request.getObservaciones()
        );


        Cumpleano actualizado =
                cumpleanoRepository.save(cumpleano);


        return mapper.toResponse(actualizado);
    }



    @Override
    public void eliminar(Integer id){

        cumpleanoRepository.deleteById(id);

    }

}