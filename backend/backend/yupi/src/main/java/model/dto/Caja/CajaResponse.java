package model.dto.Caja;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class CajaResponse {

    private Integer id_caja;
    private BigDecimal cajaApertura;
    private BigDecimal cajaCierre;
    private LocalDateTime fecha;
    private BigDecimal totalIngresos;
    private BigDecimal totalEgresos;
    private BigDecimal saldoFinal;
    private LocalDateTime fechaHoraCierre;
}
