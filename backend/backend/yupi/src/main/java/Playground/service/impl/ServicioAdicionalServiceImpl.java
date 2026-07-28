package Playground.service.impl;

import Playground.model.dto.ServicioAdicional.ServicioAdicionalRequest;
import Playground.model.dto.ServicioAdicional.ServicioAdicionalResponse;

import Playground.model.entity.ServicioAdicional;

import Playground.model.mapper.ServicioAdicionalMapper;

import Playground.repository.ServicioAdicionalRepository;

import Playground.service.ServicioAdicionalService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServicioAdicionalServiceImpl
        implements ServicioAdicionalService {


    private final ServicioAdicionalRepository repository;

    private final ServicioAdicionalMapper mapper;



    @Override
    @Transactional
    public ServicioAdicionalResponse registrar(
            ServicioAdicionalRequest request
    ){

        if(repository.existsByNombreIgnoreCase(
                request.getNombre()
        )){
            throw new RuntimeException(
                    "El servicio ya existe"
            );
        }


        ServicioAdicional servicio =
                mapper.toEntity(request);


        ServicioAdicional guardado =
                repository.save(servicio);


        return mapper.toResponse(guardado);
    }



    @Override
    @Transactional(readOnly = true)
    public List<ServicioAdicionalResponse> listar(){

        return mapper.toResponseList(
                repository.findAll()
        );
    }



    @Override
    @Transactional(readOnly = true)
    public List<ServicioAdicionalResponse> listarActivos(){

        return mapper.toResponseList(
                repository.findByEstadoTrue()
        );
    }



    @Override
    @Transactional(readOnly = true)
    public ServicioAdicionalResponse buscarPorId(
            Integer id
    ){

        ServicioAdicional servicio =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Servicio no encontrado"
                                )
                        );


        return mapper.toResponse(servicio);
    }



    @Override
    @Transactional(readOnly = true)
    public List<ServicioAdicionalResponse> buscarPorNombre(
            String nombre
    ){

        return mapper.toResponseList(
                repository.findByNombreContainingIgnoreCase(nombre)
        );
    }



    @Override
    @Transactional
    public ServicioAdicionalResponse actualizar(
            Integer id,
            ServicioAdicionalRequest request
    ){

        ServicioAdicional servicio =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Servicio no encontrado"
                                )
                        );


        servicio.setNombre(
                request.getNombre()
        );

        servicio.setPrecio(
                request.getPrecio()
        );

        ServicioAdicional actualizado =
                repository.save(servicio);


        return mapper.toResponse(actualizado);
    }



    @Override
    @Transactional
    public void eliminar(
            Integer id
    ){

        ServicioAdicional servicio =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Servicio no encontrado"
                                )
                        );


        repository.delete(servicio);
    }

}