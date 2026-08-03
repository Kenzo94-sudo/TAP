package model.dto.Acompañante;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompañanteRequest {

    private String nombre;
    private String apellidos;
    private String alergias;
}
