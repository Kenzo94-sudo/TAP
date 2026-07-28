package Playground.service;


import Playground.model.dto.Cumpleano.CumpleanoRequest;
import Playground.model.dto.Cumpleano.CumpleanoResponse;

import java.util.List;

public interface CumpleanoService {

    CumpleanoResponse registrar(CumpleanoRequest request);

    List<CumpleanoResponse> listar();

    CumpleanoResponse buscarPorId(Integer id);

    CumpleanoResponse actualizar(
            Integer id,
            CumpleanoRequest request
    );

    void eliminar(Integer id);

}