package model.dto.ServicioAdicional;

import lombok.*;
import model.dto.cumpleanos.CumpleanoResponse;
import model.entity.Cumpleano;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioAdicionalResponse {

    private Integer idServicio;
    private String nombre;
    private BigDecimal precio;
    private CumpleanoResponse cumpleanos;
}
