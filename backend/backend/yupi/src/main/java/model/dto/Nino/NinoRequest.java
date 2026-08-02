package model.dto.Nino;


import lombok.*;
import model.dto.Cliente.ClienteRequest;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class NinoRequest {

    private String nombre;
    private String apellidos;
    private int edad;

    private ClienteRequest cliente;

}
