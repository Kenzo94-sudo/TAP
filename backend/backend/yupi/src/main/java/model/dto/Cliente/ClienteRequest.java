package model.dto.Cliente;

import lombok.*;
import model.dto.Acompañante.AcompañanteRequest;
import model.dto.Nino.NinoRequest;
import model.entity.Acompañante;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {

    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;
    private String email;
    private String direccion;
    private String distrito;
    private String observacion;
    private List<NinoRequest> nino;
    private List<AcompañanteRequest> acompañante;

}