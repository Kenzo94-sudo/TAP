package model.dto.Usuario;

import lombok.*;
import model.entity.Enum.Categoria;
import model.entity.Rol;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class UsuarioCreateDTO {

    private String nombres;
    private String apellidos;
    private String correo;
    private String username;
    private String password;
    private Categoria rol;
}
