package model.dto.Caja;

import lombok.*;
import model.dto.Usuario.LoginRequestDTO;

import java.math.BigDecimal;

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
    private LoginRequestDTO usuario;
}
