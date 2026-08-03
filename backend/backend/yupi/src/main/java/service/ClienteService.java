package service;

import model.dto.Cliente.ClienteRequest;
import model.dto.Cliente.ClienteResponse;
import model.entity.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService {

    ClienteResponse registrarCliente(ClienteRequest clienteRequest);
    ClienteResponse consultarCliente(Cliente cliente, Integer id);


    ClienteResponse actualizarCliente(Integer id, ClienteRequest clienteRequest);
    ClienteResponse eliminarCliente(Integer id);
    ClienteResponse consultarClienteporNiño(Integer idNino);
    ClienteResponse consultarClienteporCumpleano(Integer idCumpleano);
}
