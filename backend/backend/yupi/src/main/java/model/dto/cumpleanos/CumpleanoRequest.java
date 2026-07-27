package model.dto.cumpleanos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.Cliente;
import model.entity.Enum.EstadoCumpleano;
import model.entity.ServicioAdicional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoRequest {

    private Integer Idcumpleano;
    private Cliente cliente;
    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cantidadNinos;
    private Integer cantidadAdultos;
    private String observaciones;
    private EstadoCumpleano estado;
    private List<ServicioAdicional> servicios;
}
