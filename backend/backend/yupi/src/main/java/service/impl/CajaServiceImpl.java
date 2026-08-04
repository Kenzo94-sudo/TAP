package service.impl;

import model.dto.Caja.CajaRequest;
import model.dto.Caja.CajaResponse;
import model.entity.Caja;
import model.mapper.CajaMapper;
import org.springframework.stereotype.Service;
import repository.CajaRepository;
import service.CajaService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.Map;

@Service
public class CajaServiceImpl implements CajaService {
    
    private CajaRepository cajaRepository;
    private CajaMapper cajaMapper;

    public CajaServiceImpl(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    @Override
    public CajaResponse registrarApertura(CajaRequest cajaRequest) {
        if (cajaRequest == null) {
            throw new IllegalArgumentException("NO SE PERMITE REGISTRO SIN DATOS");
        }
        if (cajaRequest.getCajaApertura() == null || cajaRequest.getCajaApertura().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("FALTA DATOS EN EL CAMPO DE CAJA APERTURA");
        }
        Caja caja = cajaMapper.toEntity(cajaRequest);
        caja.setFecha(LocalDateTime.now());
        Caja cajaGuardado = cajaRepository.save(caja);

        return cajaMapper.toResponse(Optional.ofNullable(cajaGuardado));
    }


    @Override
    public CajaResponse registrarCierre(CajaRequest cajaRequest) {
        if (cajaRequest == null) {
            throw new IllegalArgumentException("NO SE PERMITE REGISTRO CIERRE SIN DATOS");
        }
        if (cajaRequest.getCajaCierre() == null || cajaRequest.getCajaCierre().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("FALTAN DATOS EN EL CAMPO  CAJA CIERRE ");
        }
        Caja caja = cajaMapper.toEntity(cajaRequest);
        caja.setFechaHoraCierre(LocalDateTime.now());
        Caja cajaCierre = cajaRepository.save(caja);
        return cajaMapper.toResponse(Optional.ofNullable(cajaCierre));
    }

    @Override
    public CajaResponse consultarIngresos(Integer id, CajaRequest cajaRequest) {
        if(id == null) {
            throw new IllegalArgumentException("EL ID DE LA CONSULTA INGRESO NO PUEDE SER NULO");
        }
        Optional<Caja> cajaId = Optional.ofNullable(cajaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NO EXISTE CLIENTE CON ID" + id)));
        return cajaMapper.toResponse(cajaId);
    }

    @Override
    public Map<String, Object> consultarEgresos(Integer id, LocalDateTime fecha) {
        if( fecha == null) {
            throw new IllegalArgumentException("EL ID DE LA CONSULTA DE EGRESO NO PUEDE SER NULO");
        }

        Caja cajaDia = cajaRepository.findByDia()
                .orElseThrow(() -> new IllegalArgumentException("NO EXISTE LA CAJA"));

        LocalDateTime inicioFecha = fecha.with(LocalDateTime.MIN);
        LocalDateTime finFecha = fecha.with(LocalDateTime.MAX);

        Caja cajaFecha =cajaRepository.findByFechaBetween(inicioFecha, finFecha)
                .orElseThrow(() -> new IllegalArgumentException(" NO HAY DATOS EN LA FECHA SELECCIONADA"));

        CajaResponse responseCajaDia = cajaMapper.toResponse(Optional.ofNullable(cajaDia));
        CajaResponse responseCajaMes = cajaMapper.toResponse(Optional.ofNullable(cajaFecha));

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("cajaDia", responseCajaDia);
        resultado.put("cajaFecha", responseCajaMes);
        return resultado;
    }

    @Override
    public CajaResponse consultarSaldoFinalporFecha(LocalDateTime fecha) {
        if ( fecha == null) {
            throw new IllegalArgumentException( "LA FECHA INGRESADA NO SE ENCUENTRA EN EL SISTEMA");
        }

        LocalDateTime inicioFecha = fecha.with(LocalDateTime.MIN);
        LocalDateTime finFecha = fecha.with(LocalDateTime.MAX);

        Caja caja = cajaRepository.findByFechaBetween(inicioFecha, finFecha)
                .orElseThrow(() -> new IllegalArgumentException("NO HAY DATOS CON LA FECHA SELECCIONADA"));


        return cajaMapper.toResponse(Optional.ofNullable(caja));
    }
}
