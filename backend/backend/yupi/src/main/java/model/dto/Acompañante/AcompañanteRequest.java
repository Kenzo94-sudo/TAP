package model.dto.Acompañante;

import lombok.*;
import model.dto.Cliente.ClienteRequest;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class AcompañanteRequest {
    private String nombre;
    private String apellidos;
    private int dni;
    private ClienteRequest cliente;
}
