package model.dto.cumpleanos;


import lombok.*;
import model.dto.Cliente.ClienteResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CumpleanoResponse {

    private Integer idCumpleano;

    private ClienteResponse clienteResponse;

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
