package Playground.model.dto.Cumpleano;


import Playground.model.entity.Cliente;
import Playground.model.entity.Enum.EstadoCumpleano;
import Playground.model.entity.ServicioAdicional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoResponse {

    private Integer Idcumpleano;
    private int idCliente;
    private String Cliente;
    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cantidadNinos;
    private Integer cantidadAdultos;
    private String observaciones;
    private EstadoCumpleano estado;
    private List<ServicioAdicional> servicio;
}