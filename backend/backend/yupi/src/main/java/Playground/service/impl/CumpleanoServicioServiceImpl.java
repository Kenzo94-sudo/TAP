package Playground.service.impl;

import Playground.model.dto.Cumpleano.CumpleanoServicioRequest;
import Playground.model.dto.Cumpleano.CumpleanoServicioResponse;

import Playground.model.entity.Cumpleano;
import Playground.model.entity.CumpleanoServicio;
import Playground.model.entity.ServicioAdicional;

import Playground.model.mapper.CumpleanoServicioMapper;

import Playground.repository.CumpleanoRepository;
import Playground.repository.CumpleanoServicioRepository;
import Playground.repository.ServicioAdicionalRepository;

import Playground.service.CumpleanoServicioService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@RequiredArgsConstructor
public class CumpleanoServicioServiceImpl
        implements CumpleanoServicioService {


    private final CumpleanoServicioRepository repository;

    private final CumpleanoRepository cumpleanoRepository;

    private final ServicioAdicionalRepository servicioRepository;

    private final CumpleanoServicioMapper mapper;



    @Override
    @Transactional
    public CumpleanoServicioResponse registrar(
            CumpleanoServicioRequest request
    ) {


        Cumpleano cumpleano =
                cumpleanoRepository.findById(
                                request.getIdCumpleano()
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Cumpleano no encontrado"
                                )
                        );


        ServicioAdicional servicio =
                servicioRepository.findById(
                                request.getIdServicio()
                        );


        boolean existe =
                repository
                        .existsByCumpleanoIdCumpleanoAndServicioIdServicio(
                                request.getIdCumpleano(),
                                request.getIdServicio()
                        );


        if(existe){
            throw new RuntimeException(
                    "El servicio ya está asignado"
            );
        }


        CumpleanoServicio entidad =
                mapper.toEntity(request);


        entidad.setCumpleano(cumpleano);

        entidad.setServicio(servicio);


        entidad.setPrecioAplicado(
                servicio.getPrecio()
        );


        CumpleanoServicio guardado =
                repository.save(entidad);


        return mapper.toResponse(guardado);

    }



    @Override
    @Transactional(readOnly = true)
    public List<CumpleanoServicioResponse> listarPorCumpleano(
            Integer idCumpleano
    ){

        return mapper.toResponseList(
                repository.findByCumpleanoIdCumpleano(
                        idCumpleano
                )
        );

    }



    @Override
    @Transactional(readOnly = true)
    public CumpleanoServicioResponse buscarPorId(
            Integer id
    ){

        CumpleanoServicio servicio =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Servicio asignado no encontrado"
                                )
                        );


        return mapper.toResponse(servicio);

    }



    @Override
    @Transactional
    public CumpleanoServicioResponse actualizar(
            Integer id,
            CumpleanoServicioRequest request
    ){

        CumpleanoServicio entidad =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Registro no encontrado"
                                )
                        );


        entidad.setCantidad(
                request.getCantidad()
        );


        CumpleanoServicio actualizado =
                repository.save(entidad);


        return mapper.toResponse(
                actualizado
        );

    }



    @Override
    @Transactional
    public void eliminar(Integer id){

        repository.deleteById(id);

    }

}