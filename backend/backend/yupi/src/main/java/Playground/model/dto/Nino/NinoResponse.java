package Playground.model.dto.Nino;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NinoResponse {

    private Long idNino;

    private Long idCliente;

    private String nombres;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private Integer edad;

    private String genero;

    private String alergias;

    private String observaciones;

}