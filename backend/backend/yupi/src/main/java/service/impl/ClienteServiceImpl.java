package service.impl;

import model.dto.Cliente.ClienteRequest;
import model.dto.Cliente.ClienteResponse;
import model.entity.Cliente;
import model.mapper.ClienteMapper;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;
import service.ClienteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponse registrarCliente(ClienteRequest clienteRequest) {

        if (clienteRequest == null) {
            throw new IllegalArgumentException("NO SE PERMITE  DATOS NULOS");
        }
        if (clienteRequest.getNombre() == null || clienteRequest.getNombre().isEmpty()) {
            throw new IllegalArgumentException("FALTAN DATOS EN EL CAMPO NOMBRE");
        }
        if (clienteRequest.getApellidos() == null || clienteRequest.getApellidos().isEmpty()) {
            throw new IllegalArgumentException("FALTAN DATOS EN EL CAMPO DE APELLIDOS");
        }
        if (clienteRepository.existsByEmail(clienteRequest.getEmail())) {
            throw new IllegalArgumentException("YA EXISTE UN CLIENTE CON EMAIL " + clienteRequest.getEmail());
        };
        Cliente cliente = clienteMapper.toEntity(clienteRequest);
        cliente.setFecha_registro(LocalDateTime.now());
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.toResponse(clienteGuardado);
    }

    @Override
    public ClienteResponse consultarCliente(Cliente cliente, Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El id del cliente no puede ser nulo");
        }
        Cliente clienteId = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe cliente con id " + id));
        return clienteMapper.toResponse(clienteId);
    }

    @Override
    public ClienteResponse actualizarCliente(Integer id, ClienteRequest clienteRequest) {
        if (id == null) {
            throw new IllegalArgumentException("EL ID DEL CLIENTE NO PUEDE SER NULO");
        }
        if (clienteRequest == null) {
            throw new IllegalArgumentException("LOS DATOS NO PUEDEN ESTAR VACIOS");
        }
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe cliente con id " + id));
        if (clienteRequest.getNombre() == null || clienteRequest.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        if (clienteRequest.getEmail() == null || clienteRequest.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del cliente es obligatorio");
        }

        clienteMapper.updateEntityFromRequest(clienteRequest, clienteExistente);
        Cliente clienteActualizado = clienteRepository.save(clienteExistente);

        return clienteMapper.toResponse(clienteActualizado);
    }

    @Override
    public ClienteResponse eliminarCliente(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe cliente con id " + id));

        clienteRepository.delete(cliente);

        return clienteMapper.toResponse(cliente);
    }

    @Override
    public ClienteResponse consultarClienteporNiño(Integer idNino) {
        if (idNino == null) {
            throw new IllegalArgumentException("El id del niño no puede ser nulo");
        }
        List<Cliente> clientes = clienteRepository.findByNinosId(idNino);
        if (clientes.isEmpty()) {
            throw new IllegalArgumentException("No existen clientes asociados al niño con id " + idNino);
        }
        return (ClienteResponse) clientes.stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponse consultarClienteporCumpleano(Integer idCumpleano) {
       if (idCumpleano == null) {
           throw new IllegalArgumentException("EL ID DEL CUMPLEAÑO NO PUEDE SER NULO");
       }
       List<Cliente> clientes = clienteRepository.findByCumpleanoId(idCumpleano);
       if (clientes.isEmpty()){
           throw new IllegalArgumentException("NO EXISTEN CLIENTES ASOCIADOS AL CUMPLEAÑO CON ID:" + idCumpleano);

       }
        return (ClienteResponse) clientes.stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }
}

