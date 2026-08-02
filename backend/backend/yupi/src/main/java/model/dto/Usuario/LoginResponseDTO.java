package model.dto.Usuario;

import lombok.*;
import model.entity.Enum.Categoria;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginResponseDTO {

    private String token;
    private Integer id_usuario;
    private String username;
    private String correo;
    private Categoria rol;
}
