package service.impl;

import model.dto.Cumpleano.CumpleanoRequest;
import model.dto.Cumpleano.CumpleanoResponse;
import model.entity.Cumpleano;
import model.mapper.CumpleanoMapper;
import org.springframework.stereotype.Service;
import repository.CumpleanoRepository;
import service.CumpleanoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Optional;

@Service
public class CumpleanoServiceImpl implements CumpleanoService {

    private CumpleanoRepository cumpleanoRepository;
    private CumpleanoMapper cumpleanoMapper;

    @Override
    public CumpleanoResponse registrarCumpleano(CumpleanoRequest cumpleanoRequest) {
        if (cumpleanoRequest == null) {
            throw new NullPointerException("Existen campos obligatorios sin completar. Por favor, ingrese la información requerida.");
        }
        if (cumpleanoRequest.getFechaEvento() == null || cumpleanoRequest.getFechaEvento().isBefore(ChronoLocalDate.from(LocalDateTime.now()))){
            throw new NullPointerException("Error de validación: la fecha no puede ser menor a la fecha actual del sistema.");
        }
        Cumpleano cumpleano = cumpleanoMapper.toEntity(cumpleanoRequest);
        Cumpleano cumpleanoGuardado = cumpleanoRepository.save(cumpleano);
        return cumpleanoMapper.toResponse(cumpleanoGuardado);
    }

    @Override
    public CumpleanoResponse consultarCumpleano(Integer id, CumpleanoRequest cumpleanoRequest, LocalDate fechaEvento) {
        if ( cumpleanoRequest == null) {
            throw new NullPointerException("Existen campos obligatorios sin completar. Por favor, ingrese la información requerida");
        }
        Cumpleano cumpleanoConsulta = cumpleanoRepository.findByFecha(fechaEvento)
                .orElseThrow(() -> new NullPointerException("No existe un cumpleaños registrado con la fecha: " + fechaEvento));
        return cumpleanoMapper.toResponse(cumpleanoConsulta);
    }

    @Override
    public CumpleanoResponse consultarCumpleanoPorCliente(String nombreCliente) {
        if( nombreCliente == null) {
            throw  new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        Cumpleano cumpleanoCliente = cumpleanoRepository.findByNombre(nombreCliente)
                .orElseThrow(() -> new NullPointerException("No existe un cumpleaño registrado con el nombre" + nombreCliente));

        return cumpleanoMapper.toResponse(cumpleanoCliente);
    }

    public void eliminarCumpleano(CumpleanoRequest cumpleanoRequest, String nombreCliente) {
        Cumpleano cumpleanoEliminar = cumpleanoRepository.findByNombre(nombreCliente)
                .orElseThrow(() -> new IllegalArgumentException("No existe un cumpleaño agendado con el nombre:"+ nombreCliente));
         cumpleanoRepository.delete(cumpleanoEliminar);
    }
}
