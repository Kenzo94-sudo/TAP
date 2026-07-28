package Playground.model.dto.Cumpleano;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoServicioResponse {

    private Integer idCumpleanoServicio;

    private Integer idCumpleano;

    private Integer idServicio;

    private String nombreServicio;

    private Integer cantidad;

    private BigDecimal precioAplicado;

}