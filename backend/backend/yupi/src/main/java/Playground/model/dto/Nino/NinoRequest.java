package Playground.model.dto.Nino;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NinoRequest {

    private Long idCliente;

    private String nombres;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private String genero;

    private String alergias;

    private String observaciones;

}