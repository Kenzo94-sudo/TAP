package model.dto.Acompañante;

import lombok.*;
import model.dto.Cliente.ClienteResponse;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class AcompañanteResponse {

    private Integer id_acompañante;
    private String nombre;
    private String apellidos;
    private int dni;
    private ClienteResponse cliente;
}
