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
public class UsuarioReponseDTO {

    private Integer id_usuario;
    private String nombres;
    private String apellidos;
    private String correo;
    private String username;
    private Categoria rol;

}
