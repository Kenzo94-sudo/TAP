package model.dto.Cliente;

import lombok.*;
import model.dto.Nino.NinoRequest;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class ClienteRequest {

    private String nombre;
    private String apellidos;
    private String email;
    private int telefono;
    private String direccion;
    private Integer dni;
    private String acompañante;
    private NinoRequest nino;
    private String observaciones;
}
