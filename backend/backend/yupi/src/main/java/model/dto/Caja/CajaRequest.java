package model.dto.Caja;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class CajaRequest {

    private BigDecimal cajaApertura;
    private BigDecimal cajaCierre;
    private BigDecimal totalIngresos;
    private BigDecimal totalEgresos;
    private BigDecimal saldoFinal;
}
