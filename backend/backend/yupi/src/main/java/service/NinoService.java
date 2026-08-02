package service;

import model.dto.Nino.NinoRequest;
import model.dto.Nino.NinoResponse;
import model.entity.Nino;
import org.springframework.stereotype.Service;

@Service
public interface NinoService {

    NinoResponse registrarNino(NinoRequest ninoRequest);
    NinoResponse consultarNino(Integer id, NinoResponse ninoResponse);
    NinoResponse actualizarNino(Integer id, NinoRequest ninoRequest);
    void eliminarNino(Integer id);
    NinoResponse consultarNinoporCliente(Integer idCliente);
    NinoResponse consultarNinoporCumpleano(Integer idCumnpleano);
}
