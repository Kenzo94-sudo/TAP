package model.dto.Caja;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CajaResponse {

    private Integer id_caja;
    private BigDecimal cajaApertura;
    private BigDecimal cajaCierre;
    private LocalDateTime fechaHoraCierre;
    private BigDecimal totalIngresos;
    private BigDecimal saldoFinal;
    private String username;
}
