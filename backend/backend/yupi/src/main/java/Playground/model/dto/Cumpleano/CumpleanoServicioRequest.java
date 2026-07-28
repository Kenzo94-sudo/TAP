package Playground.model.dto.Cumpleano;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoServicioRequest {

    private Integer idCumpleano;

    private Integer idServicio;

    private Integer cantidad;

    private BigDecimal precioAplicado;

}