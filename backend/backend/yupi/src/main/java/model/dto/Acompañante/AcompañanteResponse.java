package model.dto.Acompañante;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompañanteResponse {

    private Integer id_acompañante;
    private String nombre;
    private String apellidos;
    private String nombreCliente;
    private String nombreNino;
}
