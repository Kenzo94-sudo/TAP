package model.dto.CumpleanoServicio;

import lombok.*;
import model.entity.Cumpleano;
import model.entity.ServicioAdicional;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class CumpleanoServicioResponse {

    private Integer idCumpleanoServicio;
    private Cumpleano cumpleano;
    private ServicioAdicional servicio;

}
