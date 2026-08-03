package model.dto.ServicioAdicional;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ServicioAdicionalResponse {

    private Integer idServicio;
    private String nombre;
    private BigDecimal precio;
}
