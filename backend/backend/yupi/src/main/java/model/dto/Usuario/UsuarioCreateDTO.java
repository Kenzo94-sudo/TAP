package model.dto.Usuario;

import model.entity.Enum.Categoria;
import model.entity.Rol;

public class UsuarioCreateDTO {

    private String nombres;
    private String apellidos;
    private String correo;
    private String username;
    private String password;
    private Categoria rol;
}
