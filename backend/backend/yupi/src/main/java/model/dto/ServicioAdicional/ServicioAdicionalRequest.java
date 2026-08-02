package model.dto.ServicioAdicional;

import lombok.*;
import model.entity.Cumpleano;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class ServicioAdicionalRequest {

    private String nombre;
    private BigDecimal precio;
    private List<Cumpleano> cumpleanos;
}
