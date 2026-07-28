package Playground.service;

import Playground.model.dto.Cumpleano.CumpleanoServicioRequest;
import Playground.model.dto.Cumpleano.CumpleanoServicioResponse;

import java.util.List;

public interface CumpleanoServicioService {


    // Registrar servicio adicional en un cumpleaños
    CumpleanoServicioResponse registrar(
            CumpleanoServicioRequest request
    );


    // Listar servicios de un cumpleaños
    List<CumpleanoServicioResponse> listarPorCumpleano(
            Integer idCumpleano
    );


    // Buscar servicio asignado por ID
    CumpleanoServicioResponse buscarPorId(
            Integer id
    );


    // Actualizar servicio asignado
    CumpleanoServicioResponse actualizar(
            Integer id,
            CumpleanoServicioRequest request
    );


    // Eliminar servicio de un cumpleaños
    void eliminar(
            Integer id
    );

}