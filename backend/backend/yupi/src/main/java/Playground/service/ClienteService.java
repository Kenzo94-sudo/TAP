package Playground.service;

import Playground.model.dto.Cliente.ClienteRequest;
import Playground.model.dto.Cliente.ClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse> listar();

    ClienteResponse obtenerPorId(Long id);

    ClienteResponse registrar(ClienteRequest request);

    ClienteResponse actualizar(Long id, ClienteRequest request);

    void eliminar(Long id);

}