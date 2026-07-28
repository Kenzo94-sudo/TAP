package Playground.model.dto.Login;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private Long idUsuario;

    private String nombres;

    private String apellidos;

    private String correo;

    private String rol;

    private String token;

}