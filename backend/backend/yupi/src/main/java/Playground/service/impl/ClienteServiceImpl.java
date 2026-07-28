package Playground.service.impl;




import Playground.model.dto.Cliente.ClienteRequest;
import Playground.model.dto.Cliente.ClienteResponse;
import Playground.model.entity.Cliente;
import Playground.model.mapper.ClienteMapper;
import Playground.repository.ClienteRepository;
import Playground.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public List<ClienteResponse> listar() {

        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toResponse)
                .toList();

    }

    @Override
    public ClienteResponse obtenerPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        return clienteMapper.toResponse(cliente);

    }

    @Override
    public ClienteResponse registrar(ClienteRequest request) {

        Cliente cliente = clienteMapper.toEntity(request);

        clienteRepository.save(cliente);

        return clienteMapper.toResponse(cliente);

    }

    @Override
    public ClienteResponse actualizar(Long id, ClienteRequest request) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        cliente.setNombres(request.getNombres());
        cliente.setApellidos(request.getApellidos());
        cliente.setDni(request.getDni());
        cliente.setCelular(request.getCelular());
        cliente.setCorreo(request.getCorreo());
        cliente.setDireccion(request.getDireccion());
        cliente.setDistrito(request.getDistrito());
        cliente.setGenero(request.getGenero());
        cliente.setObservacion(request.getObservacion());

        clienteRepository.save(cliente);

        return clienteMapper.toResponse(cliente);

    }

    @Override
    public void eliminar(Long id) {

        clienteRepository.deleteById(id);

    }

}