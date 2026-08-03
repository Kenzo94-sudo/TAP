package model.dto.Cliente;

import lombok.*;
import model.dto.Acompañante.AcompañanteResponse;
import model.dto.Nino.NinoRequest;
import model.dto.Nino.NinoResponse;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {

    private Integer id_cliente;
    private String nombres;
    private String apellidos;
    private String observacion;
    private List<NinoResponse> ninoResponse;
    private List<AcompañanteResponse> acompañanteResponse;
}
