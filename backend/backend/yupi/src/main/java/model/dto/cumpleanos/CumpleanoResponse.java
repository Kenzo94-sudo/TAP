package model.dto.cumpleanos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoResponse {

    private Integer idCumpleano;

    private Integer idCliente;
    private String nombreCliente;

    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    private Integer cantidadNinos;
    private Integer cantidadAdultos;

    private String observaciones;
    private String estado;

    private List<String> servicios;

    private BigDecimal montoTotal;

}
