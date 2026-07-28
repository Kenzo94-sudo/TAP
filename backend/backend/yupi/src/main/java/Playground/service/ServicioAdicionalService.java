package Playground.service;

import Playground.model.dto.ServicioAdicional.ServicioAdicionalRequest;
import Playground.model.dto.ServicioAdicional.ServicioAdicionalResponse;

import java.util.List;

public interface ServicioAdicionalService {


    // Registrar un servicio adicional
    ServicioAdicionalResponse registrar(
            ServicioAdicionalRequest request
    );


    // Listar todos los servicios
    List<ServicioAdicionalResponse> listar();


    // Listar servicios activos
    List<ServicioAdicionalResponse> listarActivos();


    // Buscar servicio por ID
    ServicioAdicionalResponse buscarPorId(
            Integer id
    );


    // Buscar por nombre
    List<ServicioAdicionalResponse> buscarPorNombre(
            String nombre
    );


    // Actualizar servicio
    ServicioAdicionalResponse actualizar(
            Integer id,
            ServicioAdicionalRequest request
    );


    // Eliminar servicio
    void eliminar(
            Integer id
    );

}