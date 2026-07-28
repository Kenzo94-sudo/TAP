package Playground.service;

import Playground.model.dto.Nino.NinoRequest;
import Playground.model.dto.Nino.NinoResponse;

import java.util.List;

public interface NinoService {

    List<NinoResponse> listar();

    List<NinoResponse> listarPorCliente(Long idCliente);

    NinoResponse obtenerPorId(Long id);

    NinoResponse registrar(NinoRequest request);

    NinoResponse actualizar(Long id, NinoRequest request);

    void eliminar(Long id);

}