package model.dto.cumpleanos;

import lombok.*;
import model.dto.Cliente.ClienteRequest;
import model.entity.Cliente;
import model.entity.Enum.EstadoCumpleano;
import model.entity.ServicioAdicional;

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
public class CumpleanoRequest {

    private ClienteRequest cliente;
    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cantidadNinos;
    private Integer cantidadAdultos;
    private String observaciones;
    private EstadoCumpleano estado;
    private List<ServicioAdicional> servicios;
}
