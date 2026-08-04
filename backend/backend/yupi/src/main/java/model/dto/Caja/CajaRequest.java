package model.dto.Caja;

import lombok.*;
import model.dto.Usuario.LoginRequestDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CajaRequest {

    private BigDecimal cajaApertura;
    private BigDecimal cajaCierre;
    private BigDecimal totalIngreso;
    private LocalDate fecha;
    private BigDecimal totalEgresos;
    private LoginRequestDTO usuario;
}
