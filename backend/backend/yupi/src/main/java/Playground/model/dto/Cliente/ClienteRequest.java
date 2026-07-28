package Playground.model.dto.Cliente;

import lombok.*;

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

    private String correo;

    private String direccion;

    private String distrito;

    private String genero;

    private String observacion;

}