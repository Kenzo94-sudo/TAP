package service;

import model.dto.Caja.CajaRequest;
import model.dto.Caja.CajaResponse;
import java.util.Map;

import java.time.LocalDateTime;

public interface CajaService {

    CajaResponse registrarApertura(CajaRequest cajaRequest);
    CajaResponse registrarCierre(CajaRequest cajaRequest);
    CajaResponse consultarIngresos(Integer id, CajaRequest cajaRequest);
    Map<String, Object>  consultarEgresos(Integer id, LocalDateTime fecha);
    CajaResponse consultarSaldoFinalporFecha(LocalDateTime fecha);

}
