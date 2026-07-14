package Playground.service.impl;


import Playground.model.dto.Nino.NinoRequest;
import Playground.model.dto.Nino.NinoResponse;
import Playground.model.entity.Cliente;
import Playground.model.entity.Nino;
import Playground.model.mapper.NinoMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import Playground.repository.ClienteRepository;
import Playground.repository.NinoRepository;
import Playground.service.NinoService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NinoServiceImpl implements NinoService {

    private final NinoRepository ninoRepository;
    private final ClienteRepository clienteRepository;
    private final NinoMapper ninoMapper;

    @Override
    public List<NinoResponse> listar() {

        return ninoRepository.findAll()
                .stream()
                .map(this::convertir)
                .toList();

    }

    @Override
    public List<NinoResponse> listarPorCliente(Long idCliente) {

        return ninoRepository.findByClienteIdCliente(idCliente)
                .stream()
                .map(this::convertir)
                .toList();

    }

    @Override
    public NinoResponse obtenerPorId(Long id) {

        return convertir(
                ninoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Niño no encontrado"))
        );

    }

    @Override
    public NinoResponse registrar(NinoRequest request) {

        Cliente cliente = clienteRepository.findById(request.getIdCliente())
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        Nino nino = ninoMapper.toEntity(request);

        nino.setCliente(cliente);

        ninoRepository.save(nino);

        return convertir(nino);

    }

    @Override
    public NinoResponse actualizar(Long id, NinoRequest request) {

        Nino nino = ninoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Niño no encontrado"));

        Cliente cliente = clienteRepository.findById(request.getIdCliente())
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        nino.setCliente(cliente);
        nino.setNombres(request.getNombres());
        nino.setApellidos(request.getApellidos());
        nino.setFechaNacimiento(request.getFechaNacimiento());
        nino.setGenero(request.getGenero());
        nino.setAlergias(request.getAlergias());
        nino.setObservaciones(request.getObservaciones());

        ninoRepository.save(nino);

        return convertir(nino);

    }

    @Override
    public void eliminar(Long id) {

        ninoRepository.deleteById(id);

    }

    private NinoResponse convertir(Nino nino) {

        NinoResponse response = ninoMapper.toResponse(nino);

        response.setEdad(
                Period.between(
                        nino.getFechaNacimiento(),
                        LocalDate.now()
                ).getYears()
        );

        return response;

    }

}