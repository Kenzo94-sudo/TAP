package model.dto.Nino;

import lombok.*;
import model.dto.Cliente.ClienteRequest;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NinoRequest{

    private String nombre;
    private LocalDate fecha_nacimiento;
    private String alergias;

}
