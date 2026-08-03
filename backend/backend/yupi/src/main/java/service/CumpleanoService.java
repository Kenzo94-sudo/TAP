package service;

import model.dto.Cumpleano.CumpleanoRequest;
import model.dto.Cumpleano.CumpleanoResponse;

public interface CumpleanoService {

    CumpleanoResponse registrarCumpleano(CumpleanoRequest cumpleanoRequest);
    CumpleanoResponse consultarCumpleano(Integer id, CumpleanoRequest cumpleanoRequest);
    CumpleanoResponse consultarCumpleanoPorCliente(Integer idCliente);
    CumpleanoResponse eliminarCumpleano(Integer id);
}
