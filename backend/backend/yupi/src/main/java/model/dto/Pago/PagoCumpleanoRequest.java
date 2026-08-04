package model.dto.Pago;

import lombok.*;
import model.entity.Enum.MedioPago;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoCumpleanoRequest {

    private Integer idCumpleano;
    private MedioPago mediaPago;
}
