package service;

import model.dto.Caja.CajaRequest;
import model.dto.Caja.CajaResponse;

public interface CajaService {

    CajaResponse registrarApertura(CajaRequest cajaRequest);
    CajaResponse registrarCierre(CajaRequest cajaRequest);
    CajaResponse consultarIngresos(Integer id, CajaRequest cajaRequest);
    CajaResponse consultarEgresos(Integer id, CajaRequest cajaRequest);
    CajaResponse consultarSaldoFinal(Integer id);

}
