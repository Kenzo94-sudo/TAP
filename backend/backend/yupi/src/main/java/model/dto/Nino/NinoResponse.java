package model.dto.Nino;

import lombok.*;
import model.dto.Cliente.ClienteResponse;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class NinoResponse {

    private Integer id_nino;
    private String nombre;
    private int edad;
    private ClienteResponse clienteResponse;
    private String observaciones;
}
