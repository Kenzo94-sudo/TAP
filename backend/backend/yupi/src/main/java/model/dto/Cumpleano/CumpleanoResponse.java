package model.dto.Cumpleano;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CumpleanoResponse {

    private Integer idCumpleano;
    private String nombreCliente;
    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cantidadNinos;
    private Integer cantidadAdultos;
    private String observaciones;
    private String estado;
    private String tipoServicioAdicional;

}
