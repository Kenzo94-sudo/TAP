package service;

import model.dto.Cumpleano.CumpleanoRequest;
import model.dto.Cumpleano.CumpleanoResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CumpleanoService {

    CumpleanoResponse registrarCumpleano(CumpleanoRequest cumpleanoRequest);
    CumpleanoResponse consultarCumpleano(Integer id, CumpleanoRequest cumpleanoRequest, LocalDate fechaEvento);
    CumpleanoResponse consultarCumpleanoPorCliente(String nombreCliente);
    void eliminarCumpleano(CumpleanoRequest cumpleanoRequest, String nombreCliente);

}
