package model.dto.Usuario;

import model.entity.Enum.Categoria;

public class LoginResponseDTO {

    private String token;
    private Integer id_usuario;
    private String username;
    private String correo;
    private Categoria rol;
}
