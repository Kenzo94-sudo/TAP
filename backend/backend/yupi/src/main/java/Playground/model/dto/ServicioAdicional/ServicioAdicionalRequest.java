package Playground.model.dto.ServicioAdicional;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioAdicionalRequest {

    private String nombre;

    private BigDecimal precio;

    private String descripcion;

    private Boolean estado;
}