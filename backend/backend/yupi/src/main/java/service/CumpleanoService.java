package service;

import model.dto.cumpleanos.CumpleanoRequest;
import model.dto.cumpleanos.CumpleanoResponse;
import model.entity.Enum.EstadoCumpleano;
import org.springframework.stereotype.Service;

@Service
public interface CumpleanoService {

    CumpleanoResponse registrarCumpleano(CumpleanoRequest cumpleanoRequest);
    CumpleanoResponse consultarCumpleano(Integer id, CumpleanoRequest cumpleanoRequest);
    CumpleanoResponse consultarCumpleanoPorCliente(Integer idCliente);
    CumpleanoResponse eliminarCumpleano(Integer id);
}
