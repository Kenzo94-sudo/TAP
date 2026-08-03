package model.dto.ServicioAdicional;


import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicioAdicionalRequest {

    private String nombre;
    private BigDecimal precio;
}
